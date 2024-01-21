package com.geeks.myhw41.ui

class TaskEditFragment : Fragment() {

    private lateinit var task: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_task_edit, container, false)

        val editText: EditText = view.findViewById(R.id.editText)
        val doneButton: Button = view.findViewById(R.id.doneButton)

        task = arguments?.getString("task") ?: ""

        editText.setText(task)

        doneButton.setOnClickListener {
            saveTask(editText.text.toString())
        }

        return view
    }

    private fun saveTask(updatedTask: String) {
        // Implement your logic to save the updated task
        // You can use the task variable to identify the task to be updated in the list
        // For simplicity, let's just update the task in the list directly
        val parentFragment = parentFragment as HomeFragment
        val position = parentFragment.taskList.indexOf(task)
        if (position != -1) {
            parentFragment.taskList[position] = updatedTask
            parentFragment.taskAdapter.notifyDataSetChanged()
        }

        // Navigate back to HomeFragment
        findNavController().popBackStack()
    }
}
