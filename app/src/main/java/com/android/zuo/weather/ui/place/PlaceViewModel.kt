package com.android.zuo.weather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.android.zuo.weather.logic.Repository
import com.android.zuo.weather.logic.model.Place

class PlaceViewModel : ViewModel() {

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getSavedPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()

    private val searchLiveData = MutableLiveData<String>()

    val placeList = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    /**
     * ui层调用此方法传入query，触发searchLiveData对象发生改变，
     * Transformations.switchMap()监听改变发起网络请求
     */
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }
}