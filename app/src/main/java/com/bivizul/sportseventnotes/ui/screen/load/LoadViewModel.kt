package com.bivizul.sportseventnotes.ui.screen.load

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.sportseventnotes.data.CardListRepositoryImpl
import com.bivizul.sportseventnotes.domain.Resource
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

    private val _resServ = MutableLiveData<Resource<ResServ>>()
    val resServ: LiveData<Resource<ResServ>> = _resServ

    fun getResServ(lp: LP) {
        viewModelScope.launch(Dispatchers.IO) {
            _resServ.postValue(Resource.Loading())
            val response = getRespServUseCase(lp)
            if (response.isSuccessful) {
                response.body()?.let {
                    _resServ.postValue(Resource.Success(it))
                }
            } else {
                _resServ.postValue(Resource.Error(response.message()))
            }
        }
    }
}