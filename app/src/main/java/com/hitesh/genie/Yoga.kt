package com.hitesh.genie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.*
import com.hitesh.genie.adapter.quotesAdapter
import com.hitesh.genie.adapter.yogaAdapter

class Yoga : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var yogaArrayList: ArrayList<yogaModel>
    lateinit var yogaAdapter: yogaAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v:View = inflater.inflate(R.layout.fragment_yoga, container, false)

        recyclerView = v.findViewById<RecyclerView>(R.id.rv_yoga)
        recyclerView.setHasFixedSize(true)
        recyclerView.setLayoutManager(
            LinearLayoutManager(context)
        )

        yogaArrayList = arrayListOf()

        yogaAdapter = yogaAdapter(yogaArrayList)
        recyclerView.adapter = yogaAdapter


        val db = FirebaseFirestore.getInstance()

        db.collection("Yoga").addSnapshotListener(object: EventListener<QuerySnapshot> {
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if(error!=null){
                    Toast.makeText(activity, "Try again", Toast.LENGTH_SHORT).show()
                    return
                }

                for(d: DocumentChange in value?.documentChanges!!){
                    if(d.type== DocumentChange.Type.ADDED)
                    {
                        yogaArrayList.add(d.document.toObject(yogaModel::class.java))
                    }
                    yogaAdapter.notifyDataSetChanged()
                }

            }

        })

        return v;
    }
}