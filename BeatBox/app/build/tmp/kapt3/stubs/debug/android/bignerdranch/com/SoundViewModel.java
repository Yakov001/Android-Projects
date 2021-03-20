package android.bignerdranch.com;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u0005J\b\u0010\r\u001a\u00020\u000eH\u0007J\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\tR\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Landroid/bignerdranch/com/SoundViewModel;", "Landroidx/databinding/BaseObservable;", "beatBox", "Landroid/bignerdranch/com/BeatBox;", "speed", "", "(Landroid/bignerdranch/com/BeatBox;F)V", "mBeatBox", "mSound", "Landroid/bignerdranch/com/Sound;", "mSpeed", "getSound", "getSpeed", "getTitle", "", "onButtonClicked", "", "setSound", "sound", "app_debug"})
public final class SoundViewModel extends androidx.databinding.BaseObservable {
    private android.bignerdranch.com.Sound mSound;
    private android.bignerdranch.com.BeatBox mBeatBox;
    private float mSpeed;
    
    @org.jetbrains.annotations.NotNull()
    public final android.bignerdranch.com.Sound getSound() {
        return null;
    }
    
    public final void setSound(@org.jetbrains.annotations.NotNull()
    android.bignerdranch.com.Sound sound) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.databinding.Bindable()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void onButtonClicked() {
    }
    
    public final float getSpeed() {
        return 0.0F;
    }
    
    public SoundViewModel(@org.jetbrains.annotations.NotNull()
    android.bignerdranch.com.BeatBox beatBox, float speed) {
        super();
    }
}