/**
 * №1873. GOV Chronicles
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1873
 *
 * Idea: We should carefully read the text and write the answer.
 *
 * This solution gets AC with 0.156s of time and 476KB of memory
 */

fun main() {
    // input
    val n = readln().toInt()

    // solution

    // Вадик путём нехитрых манипуляций попал в наполовину сформированную команду к Лёше и Мише.
    // чемпионат УрГУ - 1
    // четвертьфинал чемпионата мира - 2
    // полуфинал в Санкт-Петербурге - 3
    // выступила на чемпионате Урала - 4
    // чемпионат Татарстана - 5

    // Мише стоит покинуть команду. - 5 для Мишы (No. 0)

    // не хватает хорошего математика. На эту роль определили Сашу
    // Пришло время чемпионата УрГУ. По неясным обстоятельствам на контест не пришёл Саша - 6
    // На четвертьфинале Саша появился - 7 (Саша -1)
    // Team.GOV всё же поехала на полуфинал от УрГУ, место Саши занял Ваня Б. - 8

    // Саша поучаствовал в одном контесте (No. 3)

    // После возвращения домой Ваня Б. нашёл себе другую команду - 1 для Вани Б (No. 4)

    // В качестве третьего игрока на чемпионат Урала был приглашён Никита - 9
    // отбор на чемпионат урала - Вадик, Леша и Никита - 10
    // На чемпионате Урала не было Леши (Леша -1)

    // в Team.GOV вновь остались двое — Лёша и Вадик. - 2 для Никиты (No. 5)

    // Федя, Вадик и Леша
    // команда отыграла целых три официальных контеста подряд в одном составе - 13
    // Team.GOV приняла участие в оригинальном ACM-соревновании - 14
    // Вместо Леши - Ваня К. (Леша -2)

    // Леша был заменен на Никиту - 12 для Леши (No. 2)

    // отбор на чемпионат Урала - 15
    // у Вадика появились срочные дела в Европе (Вадик -1)
    // чемпионат Урала - 16

    // Нервы Феди и Никиты этого не выдержали, и Вадик вновь остался один.
    // Федя - 6 (No. 6)
    // Никита - 4 (No. 5)

    // Новый состав: Вадик, Ден и Егор
    // чемпионате УрГУ - 17
    // Четвертьфинал - 18
    // полуфинал - 19
    // Всесибирская олимпиада - 20

    // чемпионате Урала - 21
    // Сяохун. (No. 10 - 1)
    // Виталия - правила соревнования не позволяли участвовать в основном туре (No. 11 - 0)
    // по старой дружбе взял в команду Сашу (No. 3 - 2)

    // ACM ICPC - ему и двум его сокомандникам (Тимоте и Александр) - 22

    // Вадим - 21 (No. 1). Тимоте и Александр - 1 (No. 12; No. 13)

    // output
    println(when (n) {
        0 -> 5      // Given in task
        1 -> 21     // Example
        2 -> 12     //
        3 -> 2      //
        4 -> 1      //
        5 -> 4      // 5-th test
        6 -> 6      // 9-th test
        7 -> 1      //
        8 -> 4      //
        9 -> 4      //
        10 -> 1     //
        11 -> 0     // Example
        12 -> 1     // After 9-th test
        13 -> 1     // After 9-th test
        else -> throw RuntimeException()
    })
}