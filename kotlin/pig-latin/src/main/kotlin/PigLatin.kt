object PigLatin {
    private val pattern = Regex(
        """
        (?<consonants>                  # define named capture group for consonants
            (?!xr|yt)                   # Rule 1: consonants should not start with "xr" or "yt"
            y?                          # Rule 4: the letter 'y' is a consonant only at first position
            ((qu)|[\w&&[^aeiouy]])*     # 
        )?                              # the consonants group may be empty
        (?<base>\w+)                    # part of a word after initial consonants
        """.trimIndent(),
        RegexOption.COMMENTS
    )

    private const val template = "\${base}\${consonants}ay" // Rule 2

    fun translate(phrase: String) = phrase.replace(pattern, template)
}
