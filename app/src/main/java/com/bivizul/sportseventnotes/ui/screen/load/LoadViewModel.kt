package com.bivizul.sportseventnotes.ui.screen.load

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.sportseventnotes.data.CardListRepositoryImpl
import com.bivizul.sportseventnotes.domain.case.GetRespServUseCase
import com.bivizul.sportseventnotes.domain.model.LP
import com.bivizul.sportseventnotes.domain.model.ResServ
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadViewModel @Inject constructor(cardListRepositoryImpl: CardListRepositoryImpl) :
    ViewModel() {

    private val getRespServUseCase = GetRespServUseCase(cardListRepositoryImpl)

    private val _resServ = MutableLiveData<ResServ>()
    val resServ: LiveData<ResServ> = _resServ

    fun getResServ(lp: LP) {
        viewModelScope.launch(Dispatchers.IO) {
            getRespServUseCase(lp)?.let { response ->
                if (response.isSuccessful) {
                    response.body()?.let {
                        _resServ.postValue(response.body())
                    }
                } else {
                    _resServ.postValue(ResServ(response.message()))
                }
            }
        }
    }

}