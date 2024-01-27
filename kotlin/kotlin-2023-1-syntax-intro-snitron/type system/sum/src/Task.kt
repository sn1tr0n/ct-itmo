fun sum(a: Any, b: Any): Any? {
    if (a is Int && b is Int) {
        return a + b
    }

    if (a is Long && b is Long) {
        return a + b
    }

    if (a is Boolean && b is Boolean) {
        return a or b
    }

    if (a is String && b is String) {
        return a + b
    }

    return null
}


