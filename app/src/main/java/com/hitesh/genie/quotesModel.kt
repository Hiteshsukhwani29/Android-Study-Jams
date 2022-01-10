package com.hitesh.genie

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.PropertyName

public class quotesModel : ViewModel() {

    @PropertyName("quote")
    var quotes: String = ""
    @PropertyName("author")
    var author: String =""

    fun getQuote(): String {
        return quotes
    }

    fun getQuoteAuthor(): String {
        return author
    }

}