package com.example.roomtestproject.fragments.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomtestproject.R
import com.example.roomtestproject.adapter.NoteAdapter
import com.example.roomtestproject.constants.Constants
import com.example.roomtestproject.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    private var recyclerView: RecyclerView? = null
    private var adapter: NoteAdapter? = null

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        viewModel = ViewModelProvider(this)[StartViewModel::class.java]
        viewModel.initDB()
        recyclerView = binding.rvNotes
        adapter = NoteAdapter()
        recyclerView!!.adapter = adapter
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->
            listNotes.asReversed()
            adapter!!.setList(listNotes)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}