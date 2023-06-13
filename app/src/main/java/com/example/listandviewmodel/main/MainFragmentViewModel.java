package com.example.listandviewmodel.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;

public class MainFragmentViewModel extends ViewModel {

    public MutableLiveData<Integer> counterLiveData = new MutableLiveData(1);

    public void increment(){
        int counter = counterLiveData.getValue();
        counter++;
        counterLiveData.setValue(counter);
    }
}
