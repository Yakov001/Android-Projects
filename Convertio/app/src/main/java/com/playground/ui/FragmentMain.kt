package com.playground.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.playground.R
import com.playground.view_model.ViewModelFragmentMain
import com.playground.view_model.ViewModelFragmentMainProvider
import java.math.RoundingMode

class FragmentMain : Fragment(R.layout.fragment_main_2) {

    lateinit var mFirstCurrencyTextView: TextView
    lateinit var mSecondCurrencyTextView: TextView
    lateinit var mFirstCurrencyAmount: TextView
    lateinit var mSecondCurrencyAmount: TextView
    lateinit var mEnterAmount: EditText
    lateinit var mFirstCurrencyContainer: View
    lateinit var mSecondCurrencyContainer: View

    val viewModel: ViewModelFragmentMain by activityViewModels {
        ViewModelFragmentMainProvider(requireActivity().application)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        doRoutineWork(view)
        setOnClickListeners()
        viewModel.mDoubleLiveData.observe(viewLifecycleOwner, { amount ->
            mSecondCurrencyAmount.text = amount
                .toBigDecimal()
                .setScale(2, RoundingMode.UP)
                .toDouble()
                .toString()
        })
        setupTextChangeListener()
        setupCurrencyTextCorrespondence()
    }

    override fun onResume() {
        super.onResume()
        viewModel.run {
            update()
            writeToDb()
        }
        mEnterAmount.requestFocus()
        Log.d(TAG, "onResume")
    }

    private fun doRoutineWork(view: View) {
        mFirstCurrencyTextView = view.findViewById(R.id.first_currency)
        mFirstCurrencyAmount = view.findViewById(R.id.first_amount)
        mSecondCurrencyTextView = view.findViewById(R.id.second_currency)
        mSecondCurrencyAmount = view.findViewById(R.id.second_amount)
        mEnterAmount = view.findViewById(R.id.enter_amount_edit_text_2)
        mFirstCurrencyContainer = view.findViewById(R.id.first_currency_layout)
        mSecondCurrencyContainer = view.findViewById(R.id.second_currency_layout)
    }

    private fun setOnClickListeners(){
        mFirstCurrencyContainer.setOnClickListener {
            viewModel.mIsFirstCurrency.value = true
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main, FragmentPickCurrency())
                .commit()
        }

        mSecondCurrencyContainer.setOnClickListener {
            viewModel.mIsFirstCurrency.value = false
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_main, FragmentPickCurrency())
                .commit()
        }
    }

    private fun setupTextChangeListener() {
        mEnterAmount.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    viewModel.convert(
                        p0.toString(),
                        mFirstCurrencyTextView.text.toString(),
                        mSecondCurrencyTextView.text.toString()
                    )
                    mFirstCurrencyAmount.text = p0.toString()
                }

                override fun afterTextChanged(p0: Editable?) {}
            }
        )
    }

    private fun setupCurrencyTextCorrespondence() {
        mFirstCurrencyTextView.text = viewModel.mCurrencyPair.value?.first
        mSecondCurrencyTextView.text = viewModel.mCurrencyPair.value?.second

        if (arguments != null) {
            if (viewModel.mIsFirstCurrency.value == true) {
                mFirstCurrencyTextView.text = requireArguments().get(SELECTED_CURRENCY) as CharSequence?
            }
            if (viewModel.mIsFirstCurrency.value == false) {
                mSecondCurrencyTextView.text = requireArguments().get(SELECTED_CURRENCY) as CharSequence?
            }
        }

        viewModel.mCurrencyPair.postValue(mFirstCurrencyTextView.text.toString()
                to mSecondCurrencyTextView.text.toString())
    }

    companion object {
        const val SELECTED_CURRENCY = "currency"
        const val TAG = "Lifecycle"
    }
}