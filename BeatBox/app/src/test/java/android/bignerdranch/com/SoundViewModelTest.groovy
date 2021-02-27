package android.bignerdranch.com

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
class SoundViewModelTest {

    private BeatBox mBeatBox
    private Sound mSound
    private SoundViewModel mSubject

    void setUp() {
        super.setUp()
        mBeatBox = mock(BeatBox.class)
        mSound = Sound("asset path")
        mSubject = new SoundViewModel(mBeatBox)
        mSubject.setSound(mSound)
    }

    @Test
    void exposesSoundNameAsTitle() {
        assertThat(mSubject.getTitle(), is(mSound.getName()))
    }
}
