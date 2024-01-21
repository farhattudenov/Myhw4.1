package com.geeks.myhw41

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HomeFragment : Fragment() {

    private lateinit var taskAdapter: TaskAdapter
    private lateinit var taskList: MutableList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.taskRecyclerView)
        taskList = mutableListOf("Task 1", "Task 2", "Task 3") // Add initial tasks
        taskAdapter = TaskAdapter(taskList)
        recyclerView.adapter = taskAdapter

        // Initialize FloatingActionButton
        val fab: FloatingActionButton = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            addBlankTask()
        }

        // Handle item click in RecyclerView
        taskAdapter.setOnItemClickListener { position ->
            openTaskEditFragment(taskList[position])
        }

        return view
    }

    private fun addBlankTask() {
        taskList.add("Blank Task")
        taskAdapter.notifyDataSetChanged()
    }

    private fun openTaskEditFragment(task: String) {
        val action = HomeFragmentDirections.actionHomeFragmentToTaskEditFragment(task)
        findNavController().navigate(action)
    }
}
