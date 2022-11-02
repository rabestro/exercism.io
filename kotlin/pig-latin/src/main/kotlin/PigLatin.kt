object PigLatin {
    private val pattern = Regex("(?<consonants>(?!xr|yt)y?((qu)|[\\w&&[^aeiouy]])*)?(?<base>\\w+)")

    fun translate(phrase: String): String {
        return phrase.replace(pattern, "\${base}\${consonants}ay"
        )
    }
}
