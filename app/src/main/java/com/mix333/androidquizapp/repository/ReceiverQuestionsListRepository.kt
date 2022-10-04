package com.mix333.androidquizapp.repository

import com.mix333.androidquizapp.model.Question

class ReceiverQuestionsListRepository {
    fun receiveQuestions() = mutableListOf(
        Question(
            text = "What is Android Jetpack?",
            answers = listOf("all of these", "tools", "documentation", "libraries")
        ),
        Question(
            text = "Base class for Layout?",
            answers = listOf("ViewGroup", "ViewSet", "ViewCollection", "ViewRoot")
        ),
        Question(
            text = "Layout for complex Screens?",
            answers = listOf("ConstraintLayout", "GridLayout", "LinearLayout", "FrameLayout")
        ),
        Question(
            text = "Pushing structured data into a Layout?",
            answers = listOf("Data Binding", "Data Pushing", "Set Text", "OnClick")
        ),
        Question(
            text = "Inflate layout in fragments?",
            answers = listOf("onCreateView", "onViewCreated", "onCreateLayout", "onInflateLayout")
        ),
        Question(
            text = "Build system for Android?",
            answers = listOf("Gradle", "Graddle", "Grodle", "Groyle")
        ),
        Question(
            text = "Android vector format?",
            answers = listOf(
                "VectorDrawable",
                "AndroidVectorDrawable",
                "DrawableVector",
                "AndroidVector"
            )
        ),
        Question(
            text = "Android Navigation Component?",
            answers = listOf("NavController", "NavCentral", "NavMaster", "NavSwitcher")
        ),
        Question(
            text = "Registers app with launcher?",
            answers = listOf("intent-filter", "app-registry", "launcher-registry", "app-launcher")
        ),
        Question(
            text = "Mark a layout for Data Binding?",
            answers = listOf("<layout>", "<binding>", "<data-binding>", "<dbinding>")
        ),
        Question(
            text = "Why does a RecyclerView need an Adapter?",
            answers = listOf(
                "To create new ViewHolders and bind data to them",
                "To adapt data to display on a specific device type",
                "To create a new ViewGroup",
                "To adapt data from a data source into JSON"
            )
        ),
        Question(
            text = "Which of the following is false about collections and higher order functions in Kotlin?",
            answers = listOf(
                "Lists are unordered, while maps and sets are ordered data types.",
                "Lists, maps, and sets can all use higher order functions.",
                "Like the elements in a set, the keys in a map must be unique. However, multiple keys can map to the same value.",
                "Higher order functions such as map and filter can take lambda functions as parameters."
            )
        ),
        Question(
            text = "Given the following code, what is the result of oneWordCities[1]?\n" +
                    "val cities = listOf(\"Jeddah\", \"Bengaluru\", \"Shenzhen\", \"Abu Dhabi\"," +
                    " \"Mountain View\", \"Tripoli\", \"Bengaluru\", \"Lima\"," +
                    " \"Mandalay\", \"Tripoli\")\n" +
                    "val oneWordCities = cities.toSet().toList().filter { !it.contains(\" \")}.sorted()",
            answers = listOf("Jeddah", "Tripoli", "Abu Dhabi", "Bengaluru")
        ),
        Question(
            text = "If you open an app, and then leave the app using the back button, " +
                    "in which order were the following activity lifecycle methods called?",
            answers = listOf(
                "onCreate(), onStart(), onStop(), onDestroy()",
                "onCreate(), onStop(), onStart(), onDestroy()",
                "onStart(), onCreate(), onDestroy(), onStop()",
                "onStart(), onDestroy(), onCreate(), onStop()"
            )
        ),
        Question(
            text = "Which activity lifecycle method would be called if a dialog appears onscreen, partially obscuring an activity?",
            answers = listOf(
                "onPause() because the activity is still displayed, but no longer has focus.",
                "onStop() because the activity does not need to respond to user input while the dialog is onscreen.",
                "onResume() because the activity needed to respond to user input to display the dialog.",
                "onDestroy() because the activity does not need to exist so long as it doesn’t have focus."
            )
        ),
        Question(
            text = "Which of the following is false about intents?",
            answers = listOf(
                "An implicit intent always results in the system asking the user which app to open.",
                "Both implicit and explicit intents allow your app to launch another activity.",
                "Explicit intents require you to specify the class of the activity you want to show.",
                "Intents are performed using the startActivity() method."
            )
        ),
        Question(
            text = "In which method should you handle what happens when a button in the app bar is pressed?",
            answers = listOf(
                "onOptionsItemSelected()",
                "onCreateOptionsMenu()",
                "openOptionsMenu()",
                "onPrepareOptionsMenu()"
            )
        ),
        Question(
            text = "A ViewModel is destroyed after which of the following ?",
            answers = listOf(
                "after onDestroy, if it not a configuration change",
                "always after onStop",
                "always after onDestroy",
                "none of the above"
            )
        ),
        Question(
            text = "Why should you initialize and store LiveData in your ViewModel instead of a UI Controller?",
            answers = listOf(
                "All of the above",
                "Both the ViewModel and LiveData are lifecycle aware.",
                "To ensure that the LiveData isn’t destroyed when the UI Controller is destroyed.",
                "To hide or separate implementation details making your app more flexible."
            )
        ),
        Question(
            text = "Which of the following allows you to use observe for changes?",
            answers = listOf(
                "a LiveData object",
                "any mutable object",
                "any property in a ViewModel",
                "any property in a ViewModel or LiveData object"
            )
        ),
        Question(
            text = "What is the correct way to access the shared view model using the Kotin property delegate approach?",
            answers = listOf(
                "val viewModel: OrderViewModel by activityViewModels()",
                "val viewModel: OrderViewModel by viewModels()",
                "val viewModel: OrderViewModel by sharedViewModels()",
                "val viewModel: OrderViewModel by fragmentViewModels()"
            )
        ),
        Question(
            text = "How can the apply function in Kotlin be used to configure an object?",
            answers = listOf(
                "It can apply a set of assignments to the object.",
                "It can directly apply the object.",
                "It can apply new instances from the object.",
                "It is not recommended to use apply to configure an object."
            )
        ),
        Question(
            text = "Which statement below is true about coroutines?",
            answers = listOf(
                "A coroutine may or may not execute.",
                "Once started, a coroutine cannot be canceled.",
                "A coroutine always runs on the main thread.",
                "Coroutines avoid the need to create new threads, by running every task on the same thread."
            )
        ),
        Question(
            text = "Which statement below is false about async() and runBlocking()?",
            answers = listOf(
                "Both functions return a Deferred",
                "Both functions take a CoroutineScope (a suspend function) as a parameter.",
                "You'll typically not use runBlocking in Android app code.",
                "When using async, you need to use await() to access the returned value."
            )
        ),
        Question(
            text = "What is responsible for determining which thread is used behind the scenes by a coroutine?",
            answers = listOf(
                "Dispatcher",
                "CoroutineScope",
                "Job",
                "GlobalScope"
            )
        )
    )
}