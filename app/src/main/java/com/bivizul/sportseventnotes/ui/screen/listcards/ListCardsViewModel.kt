package com.bivizul.sportseventnotes.ui.screen.listcards

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.sportseventnotes.data.CardListRepositoryImpl
import com.bivizul.sportseventnotes.domain.case.AddCardItemUseCase
import com.bivizul.sportseventnotes.domain.case.DeleteCardItemUseCase
import com.bivizul.sportseventnotes.domain.case.EditCardItemUseCase
import com.bivizul.sportseventnotes.domain.case.GetCardListUseCase
import com.bivizul.sportseventnotes.domain.model.CardItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListCardsViewModel @Inject constructor(cardListRepositoryImpl: CardListRepositoryImpl):ViewModel() {

    private val addCardItemUseCase = AddCardItemUseCase(cardListRepositoryImpl)
    private val deleteCardItemUseCase = DeleteCardItemUseCase(cardListRepositoryImpl)
    private val editCardItemUseCase = EditCardItemUseCase(cardListRepositoryImpl)
    private val getCardListUseCase = GetCardListUseCase(cardListRepositoryImpl)

    fun getCardsList() =  getCardListUseCase()

    fun addCardItem(cardItem: CardItem){
        viewModelScope.launch(Dispatchers.IO) {
            addCardItemUseCase(cardItem)
        }
    }

    fun editCardItem(cardItem: CardItem){
        viewModelScope.launch(Dispatchers.IO) {
            editCardItemUseCase(cardItem)
        }
    }

    fun deleteCardItem(cardItem: CardItem){
        viewModelScope.launch(Dispatchers.IO) {
            deleteCardItemUseCase(cardItem)
        }
    }

    fun changeEnableState(cardItem: CardItem){
        viewModelScope.launch(Dispatchers.IO) {
//            val newItem = cardItem.copy(enable = !cardItem.enable)
//            editCardItemUseCase(newItem)
        }
    }

    // Инициализация базы данных
//    fun initDatabase(type: String, onSuccess: () -> Unit) {
//        Log.d("checkData", "MainViewModel initDatabase with type $type")
//        when (type) {
//            TYPE_ROOM -> {
//                val dao = AppRoomDatabase.getInstance(context).getRoomDao()
//                REPOSITORY = RoomRepository(dao)
//                onSuccess()
//            }
//            TYPE_FIREBASE -> {
//                REPOSITORY = AppFirebaseRepository()
//                REPOSITORY.connectToDatabase(
//                    { onSuccess() },
//                    { Log.d("checkData", "Error: $it") }
//                )
//
//            }
//        }
//    }

//    // Добавление заметки в локальную базу данных
//    fun addNote(note: Note, onSuccess: () -> Unit) {
//        // Запускаем в потоке InputOutput создачу заметки
//        viewModelScope.launch(Dispatchers.IO) {
//            REPOSITORY.create(note = note) {
//                // Запускаем в главном потоке callback
//                viewModelScope.launch(Dispatchers.Main) {
//                    onSuccess()
//                }
//            }
//        }
//    }
//
//    // Обновление заметки
//    fun updateNote(note: Note, onSuccess: () -> Unit) {
//        viewModelScope.launch(Dispatchers.IO) {
//            REPOSITORY.update(note = note) {
//                viewModelScope.launch(Dispatchers.Main) {
//                    onSuccess()
//                }
//            }
//        }
//    }
//
//    // Удаление заметки
//    fun deleteNote(note: Note, onSuccess: () -> Unit) {
//        viewModelScope.launch(Dispatchers.IO) {
//            REPOSITORY.delete(note = note) {
//                viewModelScope.launch(Dispatchers.Main) {
//                    onSuccess()
//                }
//            }
//        }
//    }
//
//    // Загрузка заметок из локальной базы данных Room
//    fun readAllNotes() = REPOSITORY.readAll
//
//    fun signOut(onSuccess: () -> Unit) {
//        when (DB_TYPE.value) {
//            TYPE_FIREBASE, TYPE_ROOM -> {
//                REPOSITORY.signOut()
//                DB_TYPE.value = EMPTY
//                onSuccess()
//            }
//            else -> {
//                Log.d("checkData", "signOut: ELSE: ${DB_TYPE.value}")
//            }
//        }
//    }

}