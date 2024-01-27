fun main() {
    val list: List<Int> = listOf(1, 2, 3)
    val mutableList: MutableList<Int> = mutableListOf(1, 2, 3)

    print(list)
    mutableList[1] = 3
    print(mutableList)

    val builderList = buildList {
        add(1)
    }

    print(builderList)
}
