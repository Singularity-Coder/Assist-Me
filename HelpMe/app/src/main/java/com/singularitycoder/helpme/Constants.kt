package com.singularitycoder.helpme

const val TAG_ADD_API_KEY_BOTTOM_SHEET = "TAG_ADD_API_KEY_BOTTOM_SHEET"

// Is there a way to iterate over color values?
val taskList by lazy {
    listOf(
        Task(
            id = 0,
            name = "Q & A",
            description = "Answer questions based on existing knowledge.",
            icon = R.drawable.ic_round_help_24,
            backgroundColor = R.color.md_red_50,
            nameColor = R.color.md_red_dark,
            descriptionColor = R.color.md_red_400,
            iconColor = R.color.md_red_400,
        ),
        Task(
            id = 1,
            name = "Grammar correction",
            description = "Corrects sentences into standard English.",
            icon = R.drawable.round_school_24,
            backgroundColor = R.color.md_pink_50,
            nameColor = R.color.md_pink_dark,
            descriptionColor = R.color.md_pink_400,
            iconColor = R.color.md_pink_400,
        ),
        Task(
            id = 2,
            name = "Summarize for a 2nd grader",
            description = "Translates difficult text into simpler concepts.",
            icon = R.drawable.ic_round_fast_forward_24,
            backgroundColor = R.color.md_purple_50,
            nameColor = R.color.md_purple_dark,
            descriptionColor = R.color.md_purple_400,
            iconColor = R.color.md_purple_400,
        ),
        Task(
            id = 3,
            name = "Natural language to OpenAI API",
            description = "Create code to call to the OpenAI API using a natural language instruction.",
            icon = R.drawable.round_chat_24,
            backgroundColor = R.color.md_deep_purple_50,
            nameColor = R.color.md_deep_purple_dark,
            descriptionColor = R.color.md_deep_purple_400,
            iconColor = R.color.md_deep_purple_400,
        ),
        Task(
            id = 4,
            name = "Text to command",
            description = "Translate text into programmatic commands.",
            icon = R.drawable.round_terminal_24,
            backgroundColor = R.color.md_indigo_50,
            nameColor = R.color.md_indigo_dark,
            descriptionColor = R.color.md_indigo_400,
            iconColor = R.color.md_indigo_400,
        ),
        Task(
            id = 5,
            name = "English to other languages",
            description = "Translates English text into French, Spanish and Japanese.",
            icon = R.drawable.round_translate_24,
            backgroundColor = R.color.md_blue_50,
            nameColor = R.color.md_blue_dark,
            descriptionColor = R.color.md_blue_400,
            iconColor = R.color.md_blue_400,
        ),
        Task(
            id = 6,
            name = "Natural language to Stripe API",
            description = "Create code to call the Stripe API using natural language.",
            icon = R.drawable.ic_round_monetization_on_24,
            backgroundColor = R.color.md_light_blue_50,
            nameColor = R.color.md_light_blue_dark,
            descriptionColor = R.color.md_light_blue_400,
            iconColor = R.color.md_light_blue_400,
        ),
        Task(
            id = 6,
            name = "SQL translate",
            description = "Translate natural language to SQL queries.",
            icon = R.drawable.round_translate_24,
            backgroundColor = R.color.md_cyan_50,
            nameColor = R.color.md_cyan_dark,
            descriptionColor = R.color.md_cyan_400,
            iconColor = R.color.md_cyan_400,
        ),
        Task(
            id = 6,
            name = "Parse unstructured data",
            description = "Create tables from long form text by specifying a structure and supplying some examples.",
            icon = R.drawable.round_table_chart_24,
            backgroundColor = R.color.md_teal_50,
            nameColor = R.color.md_teal_dark,
            descriptionColor = R.color.md_teal_400,
            iconColor = R.color.md_teal_400,
        ),
        Task(
            id = 6,
            name = "Classification",
            description = "Classify items into categories via example.",
            icon = R.drawable.round_local_offer_24,
            backgroundColor = R.color.md_green_50,
            nameColor = R.color.md_green_dark,
            descriptionColor = R.color.md_green_400,
            iconColor = R.color.md_green_400,
        ),
        Task(
            id = 6,
            name = "Python to natural language",
            description = "Explain a piece of Python code in human understandable language.",
            icon = R.drawable.round_spatial_audio_off_24,
            backgroundColor = R.color.md_light_green_50,
            nameColor = R.color.md_light_green_dark,
            descriptionColor = R.color.md_light_green_400,
            iconColor = R.color.md_light_green_400,
        ),
        Task(
            id = 6,
            name = "Movie to Emoji",
            description = "Convert movie titles into emoji.",
            icon = R.drawable.round_emoji_emotions_24,
            backgroundColor = R.color.md_lime_50,
            nameColor = R.color.md_lime_dark,
            descriptionColor = R.color.md_lime_400,
            iconColor = R.color.md_lime_400,
        ),
        Task(
            id = 6,
            name = "Calculate Time Complexity",
            description = "Find the time complexity of a function.",
            icon = R.drawable.ic_round_access_time_filled_24,
            backgroundColor = R.color.md_yellow_50,
            nameColor = R.color.md_yellow_dark,
            descriptionColor = R.color.md_yellow_400,
            iconColor = R.color.md_yellow_400,
        ),
        Task(
            id = 6,
            name = "Translate programming languages",
            description = "To translate from one programming language to another we can use the comments to specify the source and target languages.",
            icon = R.drawable.round_translate_24,
            backgroundColor = R.color.md_amber_50,
            nameColor = R.color.md_amber_dark,
            descriptionColor = R.color.md_amber_400,
            iconColor = R.color.md_amber_400,
        ),
        Task(
            id = 6,
            name = "Advanced tweet classifier",
            description = "This is an advanced prompt for detecting sentiment. It allows you to provide it with a list of status updates and then provide a sentiment for each one.",
            icon = R.drawable.ic_twitter,
            backgroundColor = R.color.md_orange_50,
            nameColor = R.color.md_orange_dark,
            descriptionColor = R.color.md_orange_400,
            iconColor = R.color.md_orange_400,
        ),
        Task(
            id = 6,
            name = "Explain code",
            description = "Explain a complicated piece of code.",
            icon = R.drawable.round_spatial_audio_off_24,
            backgroundColor = R.color.md_deep_orange_50,
            nameColor = R.color.md_deep_orange_dark,
            descriptionColor = R.color.md_deep_orange_400,
            iconColor = R.color.md_deep_orange_400,
        ),
        Task(
            id = 6,
            name = "Keywords",
            description = "Extract keywords from a block of text. At a lower temperature it picks keywords from the text. At a higher temperature it will generate related keywords which can be helpful for creating search indexes.",
            icon = R.drawable.round_key_24,
            backgroundColor = R.color.md_brown_50,
            nameColor = R.color.md_brown_900,
            descriptionColor = R.color.md_brown_400,
            iconColor = R.color.md_brown_400,
        ),
        Task(
            id = 6,
            name = "Factual answering",
            description = "Guide the model towards factual answering by showing it how to respond to questions that fall outside its knowledge base. Using a '?' to indicate a response to words and phrases that it doesn't know provides a natural response that seems to work better than more abstract replies.",
            icon = R.drawable.ic_round_help_24,
            backgroundColor = R.color.md_grey_50,
            nameColor = R.color.md_grey_900,
            descriptionColor = R.color.md_grey_400,
            iconColor = R.color.md_grey_400,
        ),
        Task(
            id = 6,
            name = "Ad from product description",
            description = "Turn a product description into ad copy.",
            icon = R.drawable.round_campaign_24,
            backgroundColor = R.color.md_blue_grey_50,
            nameColor = R.color.md_blue_grey_900,
            descriptionColor = R.color.md_blue_grey_400,
            iconColor = R.color.md_blue_grey_400,
        ),
        Task(
            id = 6,
            name = "Product name generator",
            description = "Create product names from examples words. Influenced by a community prompt.",
            icon = R.drawable.round_tips_and_updates_24,
            backgroundColor = R.color.md_grey_50,
            nameColor = R.color.md_grey_900,
            descriptionColor = R.color.md_grey_400,
            iconColor = R.color.md_grey_400,
        ),
        Task(
            id = 6,
            name = "TL;DR summarization",
            description = "Summarize text by adding a 'tl;dr:' to the end of a text passage. It shows that the API understands how to perform a number of tasks with no instructions.",
            icon = R.drawable.ic_round_filter_alt_24,
            backgroundColor = R.color.md_brown_50,
            nameColor = R.color.md_brown_900,
            descriptionColor = R.color.md_brown_400,
            iconColor = R.color.md_brown_400,
        ),
        Task(
            id = 6,
            name = "Python bug fixer",
            description = "There's a number of ways of structuring the prompt for checking for bugs. Here we add a comment suggesting that source code is buggy, and then ask codex to generate a fixed code.",
            icon = R.drawable.ic_round_bug_report_24,
            backgroundColor = R.color.md_deep_orange_50,
            nameColor = R.color.md_deep_orange_dark,
            descriptionColor = R.color.md_deep_orange_400,
            iconColor = R.color.md_deep_orange_400,
        ),
        Task(
            id = 6,
            name = "Spreadsheet creator",
            description = "Create spreadsheets of various kinds of data. It's a long prompt but very versatile. Output can be copy+pasted into a text file and saved as a .csv with pipe separators.",
            icon = R.drawable.round_table_chart_24,
            backgroundColor = R.color.md_orange_50,
            nameColor = R.color.md_orange_dark,
            descriptionColor = R.color.md_orange_400,
            iconColor = R.color.md_orange_400,
        ),
        Task(
            id = 6,
            name = "JavaScript helper chatbot",
            description = "This is a message-style chatbot that can answer questions about using JavaScript. It uses a few examples to get the conversation started.",
            icon = R.drawable.round_smart_toy_24,
            backgroundColor = R.color.md_amber_50,
            nameColor = R.color.md_amber_dark,
            descriptionColor = R.color.md_amber_400,
            iconColor = R.color.md_amber_400,
        ),
        Task(
            id = 6,
            name = "ML/AI language model tutor",
            description = "This is a QA-style chatbot that answers questions about language models.",
            icon = R.drawable.round_smart_toy_24,
            backgroundColor = R.color.md_yellow_50,
            nameColor = R.color.md_yellow_dark,
            descriptionColor = R.color.md_yellow_400,
            iconColor = R.color.md_yellow_400,
        ),
        Task(
            id = 6,
            name = "Science fiction book list maker",
            description = "This makes a list of science fiction books and stops when it reaches #10.",
            icon = R.drawable.round_auto_stories_24,
            backgroundColor = R.color.md_lime_50,
            nameColor = R.color.md_lime_dark,
            descriptionColor = R.color.md_lime_400,
            iconColor = R.color.md_lime_400,
        ),
        Task(
            id = 6,
            name = "Tweet classifier",
            description = "This is a basic prompt for detecting sentiment.",
            icon = R.drawable.ic_twitter,
            backgroundColor = R.color.md_light_green_50,
            nameColor = R.color.md_light_green_dark,
            descriptionColor = R.color.md_light_green_400,
            iconColor = R.color.md_light_green_400,
        ),
        Task(
            id = 6,
            name = "Airport code extractor",
            description = "A simple prompt for extracting airport codes from text.",
            icon = R.drawable.round_ios_share_24,
            backgroundColor = R.color.md_green_50,
            nameColor = R.color.md_green_dark,
            descriptionColor = R.color.md_green_400,
            iconColor = R.color.md_green_400,
        ),
        Task(
            id = 6,
            name = "SQL request",
            description = "Create simple SQL queries.",
            icon = R.drawable.ic_round_help_24,
            backgroundColor = R.color.md_teal_50,
            nameColor = R.color.md_teal_dark,
            descriptionColor = R.color.md_teal_400,
            iconColor = R.color.md_teal_400,
        ),
        Task(
            id = 6,
            name = "Extract contact information",
            description = "Extract contact information from a block of text.",
            icon = R.drawable.ic_round_email_24,
            backgroundColor = R.color.md_cyan_50,
            nameColor = R.color.md_cyan_dark,
            descriptionColor = R.color.md_cyan_400,
            iconColor = R.color.md_cyan_400,
        ),
        Task(
            id = 6,
            name = "JavaScript to Python",
            description = "Convert simple JavaScript expressions into Python.",
            icon = R.drawable.round_data_object_24,
            backgroundColor = R.color.md_light_blue_50,
            nameColor = R.color.md_light_blue_dark,
            descriptionColor = R.color.md_light_blue_400,
            iconColor = R.color.md_light_blue_400,
        ),
        Task(
            id = 6,
            name = "Friend chat",
            description = "Emulate a text message conversation.",
            icon = R.drawable.ic_round_question_answer_24,
            backgroundColor = R.color.md_blue_50,
            nameColor = R.color.md_blue_dark,
            descriptionColor = R.color.md_blue_400,
            iconColor = R.color.md_blue_400,
        ),
        Task(
            id = 6,
            name = "Mood to color",
            description = "Turn a text description into a color.",
            icon = R.drawable.round_sentiment_very_dissatisfied_24,
            backgroundColor = R.color.md_indigo_50,
            nameColor = R.color.md_indigo_dark,
            descriptionColor = R.color.md_indigo_400,
            iconColor = R.color.md_indigo_400,
        ),
        Task(
            id = 6,
            name = "Write a Python docstring",
            description = "An example of how to create a docstring for a given Python function. We specify the Python version, paste in the code, and then ask within a comment for a docstring, and give a characteristic beginning of a docstring (\"\"\").",
            icon = R.drawable.round_data_object_24,
            backgroundColor = R.color.md_deep_purple_50,
            nameColor = R.color.md_deep_purple_dark,
            descriptionColor = R.color.md_deep_purple_400,
            iconColor = R.color.md_deep_purple_400,
        ),
        Task(
            id = 6,
            name = "Analogy maker",
            description = "Create analogies. Modified from a community prompt to require fewer examples.",
            icon = R.drawable.round_tips_and_updates_24,
            backgroundColor = R.color.md_purple_50,
            nameColor = R.color.md_purple_dark,
            descriptionColor = R.color.md_purple_400,
            iconColor = R.color.md_purple_400,
        ),
        Task(
            id = 6,
            name = "JavaScript one line function",
            description = "Turn a JavaScript function into a one liner.",
            icon = R.drawable.round_data_object_24,
            backgroundColor = R.color.md_pink_50,
            nameColor = R.color.md_pink_dark,
            descriptionColor = R.color.md_pink_400,
            iconColor = R.color.md_pink_400,
        ),
        Task(
            id = 6,
            name = "Micro horror story creator",
            description = "Creates two to three sentence short horror stories from a topic input.",
            icon = R.drawable.round_history_edu_24,
            backgroundColor = R.color.md_red_50,
            nameColor = R.color.md_red_dark,
            descriptionColor = R.color.md_red_400,
            iconColor = R.color.md_red_400,
        ),
        Task(
            id = 6,
            name = "Third-person converter",
            description = "Converts first-person POV to the third-person. This is modified from a community prompt to use fewer examples.",
            icon = R.drawable.ic_round_edit_note_24,
            backgroundColor = R.color.md_pink_50,
            nameColor = R.color.md_pink_dark,
            descriptionColor = R.color.md_pink_400,
            iconColor = R.color.md_pink_400,
        ),
        Task(
            id = 6,
            name = "Notes to summary",
            description = "Turn meeting notes into a summary.",
            icon = R.drawable.ic_round_photo_size_select_small_24,
            backgroundColor = R.color.md_purple_50,
            nameColor = R.color.md_purple_dark,
            descriptionColor = R.color.md_purple_400,
            iconColor = R.color.md_purple_400,
        ),
        Task(
            id = 6,
            name = "VR fitness idea generator",
            description = "Create ideas for fitness and virtual reality games.",
            icon = R.drawable.round_tips_and_updates_24,
            backgroundColor = R.color.md_deep_purple_50,
            nameColor = R.color.md_deep_purple_dark,
            descriptionColor = R.color.md_deep_purple_400,
            iconColor = R.color.md_deep_purple_400,
        ),
        Task(
            id = 6,
            name = "ESRB rating",
            description = "Categorize text based upon ESRB ratings.",
            icon = R.drawable.round_local_offer_24,
            backgroundColor = R.color.md_indigo_50,
            nameColor = R.color.md_indigo_dark,
            descriptionColor = R.color.md_indigo_400,
            iconColor = R.color.md_indigo_400,
        ),
        Task(
            id = 6,
            name = "Essay outline",
            description = "Generate an outline for a research topic.",
            icon = R.drawable.ic_round_photo_size_select_small_24,
            backgroundColor = R.color.md_blue_50,
            nameColor = R.color.md_blue_dark,
            descriptionColor = R.color.md_blue_400,
            iconColor = R.color.md_blue_400,
        ),
        Task(
            id = 6,
            name = "Recipe creator (eat at your own risk)",
            description = "Create a recipe from a list of ingredients.",
            icon = R.drawable.round_cake_24,
            backgroundColor = R.color.md_light_blue_50,
            nameColor = R.color.md_light_blue_dark,
            descriptionColor = R.color.md_light_blue_400,
            iconColor = R.color.md_light_blue_400,
        ),
        Task(
            id = 6,
            name = "Chat",
            description = "Open ended conversation with an AI assistant.",
            icon = R.drawable.ic_round_question_answer_24,
            backgroundColor = R.color.md_cyan_50,
            nameColor = R.color.md_cyan_dark,
            descriptionColor = R.color.md_cyan_400,
            iconColor = R.color.md_cyan_400,
        ),
        Task(
            id = 6,
            name = "Marv the sarcastic chat bot",
            description = "Marv is a factual chatbot that is also sarcastic.",
            icon = R.drawable.round_smart_toy_24,
            backgroundColor = R.color.md_teal_50,
            nameColor = R.color.md_teal_dark,
            descriptionColor = R.color.md_teal_400,
            iconColor = R.color.md_teal_400,
        ),
        Task(
            id = 6,
            name = "Turn by turn directions",
            description = "Convert natural language to turn-by-turn directions.",
            icon = R.drawable.round_location_on_24,
            backgroundColor = R.color.md_green_50,
            nameColor = R.color.md_green_dark,
            descriptionColor = R.color.md_green_400,
            iconColor = R.color.md_green_400,
        ),
        Task(
            id = 6,
            name = "Restaurant review creator",
            description = "Turn a few words into a restaurant review.",
            icon = R.drawable.ic_baseline_reviews_24,
            backgroundColor = R.color.md_light_green_50,
            nameColor = R.color.md_light_green_dark,
            descriptionColor = R.color.md_light_green_400,
            iconColor = R.color.md_light_green_400,
        ),
        Task(
            id = 6,
            name = "Create study notes",
            description = "Provide a topic and get study notes.",
            icon = R.drawable.round_text_snippet_24,
            backgroundColor = R.color.md_lime_50,
            nameColor = R.color.md_lime_dark,
            descriptionColor = R.color.md_lime_400,
            iconColor = R.color.md_lime_400,
        ),
        Task(
            id = 6,
            name = "Interview questions",
            description = "Create interview questions.",
            icon = R.drawable.ic_round_help_24,
            backgroundColor = R.color.md_yellow_50,
            nameColor = R.color.md_yellow_dark,
            descriptionColor = R.color.md_yellow_400,
            iconColor = R.color.md_yellow_400,
        ),
    )
}