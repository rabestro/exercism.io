object PigLatin {
    private val pattern = Regex(
        """
        (?<moved>                       # define named capturing group for moved letters
            (?!xr|yt)                   # Rule 1: consonants should not start with "xr" or "yt"
            y?                          # Rule 4: the letter 'y' is a consonant only at first position
            (qu|[[a-z]&&[^aeiouy]])*    # Rule 3: word starts with a consonant sound followed by "qu"
        )?                              # the moved group may be empty
        (?<base>\w+)                    # part of a word after initial consonants
        """.trimIndent(),
        RegexOption.COMMENTS
    )

    private const val template = "\${base}\${moved}ay"

    fun translate(phrase: String) = phrase.replace(pattern, template)
}
