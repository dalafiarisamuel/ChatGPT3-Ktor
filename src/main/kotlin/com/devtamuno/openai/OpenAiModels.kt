package com.devtamuno.openai

object OpenAiModels {

    object Text {
        const val DAVINCI_002 = "text-davinci-002"

        /**
         * Most capable GPT-3 model. Can do any task the other models can do, often with higher quality,
         * longer output and better instruction-following. Also supports inserting completions within text.
         * Good at: Complex intent, cause and effect, summarization for audience
         * */
        const val DAVINCI_003 = "text-davinci-003"
        const val DAVINCI_001 = "text-davinci-001"


        /**
         * Very capable, but faster and lower cost than Davinci.
         * Good at: Language translation, complex classification, text sentiment, summarization
         * */
        const val CURIE_001 = "text-curie-001"

        /**
         * Capable of straightforward tasks, very fast, and lower cost
         * Good at: Moderate classification, semantic search classification
         * */
        const val BABBAGE_001 = "text-babbage-001"

        /**
         * Capable of very simple tasks, usually the fastest model in the GPT-3 series, and lowest cost.
         * Good at: Parsing text, simple classification, address correction, keywords
         **/
        const val ADA_001 = "text-ada-001"
    }

    object Code {
        const val DAVINCI_002 = "code-davinci-002"
        const val CUSHMAN_001 = "code-cushman-001"
    }
}