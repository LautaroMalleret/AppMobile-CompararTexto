package com.curso.android.app.practica.appcompartexto.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.app.practica.appcompartexto.model.Response
import com.curso.android.app.practica.appcompartexto.model.TypeResponse

class MainViewModel: ViewModel() {

    val response: LiveData<Response> get() = _response
    private var _response = MutableLiveData<Response>(Response(TypeResponse.EMPTY))

    fun textsComparison(text1: String, text2: String, compareUpperCase: Boolean){
        if(text1.isEmpty() && text2.isEmpty()){
            setResponse(TypeResponse.EMPTY)
        }
        else if(compareUpperCase){
            if(text1.contentEquals(text2))
                setResponse(TypeResponse.EQUAL)
            else
                setResponse(TypeResponse.DIFFERENT)
        }
        else{
            if(text1.lowercase()compareTo(text2.lowercase())==0)
                setResponse(TypeResponse.EQUAL)
            else
                setResponse(TypeResponse.DIFFERENT)        }
    }

     private fun setResponse(response: TypeResponse){
        _response.value = Response(response)
    }
}

