class StackImpl<T : Any> : Stack<T> {

    private val storage = arrayListOf<T>()

    override fun push(element: T) {
        storage.add(element)
    }

    override fun pop(): T? {
        val temp = storage.lastOrNull()
        storage.removeLast()
        return temp
    }

    override fun peek(): T? {
        return storage.lastOrNull()
    }

    override val count: Int
        get() = storage.size

    override val isEmpty: Boolean
        get() = storage.isEmpty()

}

fun String.validParenthesis(): Boolean {

    val stack = StackImpl<Char>()

    for(char in this) {
        when (char) {
            '(' -> {
                stack.push(char)
            }
            ')' -> {
                if (!stack.isEmpty) {
                    stack.pop()
                } else {
                    return false
                }
            }
        }
    }
    return true
}