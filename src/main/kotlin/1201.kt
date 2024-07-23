/**
 * №1201. Which Day Is It?
 *
 * Link: https://acm.timus.ru/problem.aspx?space=1&num=1201
 *
 * Idea: 1/1/1600 is Saturday. So, calculate which day of the week
 * is 1/1/<year, we've input> by calculating leap and all years
 * between 1600 -> year; 365 % 7 = 1, 366 % 7 = 2, so
 * the day of the week will be (Saturday + all years + leap years) % 7
 * Next, we're calculating day of the week of the month of the given year.
 * Finally, we're building an answer.
 *
 * This solution gets AC with 0.203s of time and 3 832KB of memory
 */

enum class DayOfWeek(val value: Int, val alias: String) {
    MONDAY(0, "mon"),
    TUESDAY(1, "tue"),
    WEDNESDAY(2, "wed"),
    THURSDAY(3, "thu"),
    FRIDAY(4, "fri"),
    SATURDAY(5, "sat"),
    SUNDAY(6, "sun");

    fun increase(): DayOfWeek = entries[(ordinal + 1) % entries.size]

    companion object {
        fun fromValue(value: Int) = entries.first { it.value == value }
    }
}

fun main() {
    // input
    val (day, month, year) = readln().split(' ').map { it.toInt() }

    // solution
    val isLeapYear = year % 4 == 0 && year % 100 != 0 || year % 400 == 0

    // 1/01/2024 is Monday
    // ->
    // 1/01/2023 is Sunday
    // 1/01/2022 is Saturday
    // 1/01/2021 is Friday
    // 1/01/2020 is Wednesday
    // 1/01/2019 is Tuesday
    // 1/01/1600:
    // 1600-1700: 25 leap years
    // 1700-1800-->2000: 24*2 + 25 leap years = 98 leap years
    // 2001-2024 - 5 leap years -> 103 leap years
    // 2024->1600 - 424 years, 103 leap
    // Monday - 527 % 7 days -> 1/01/1600 is Saturday

    val firstJanuary1600 = DayOfWeek.SATURDAY
    val yearsFrom1600 = year - 1600
    val leapYearsFrom1600 =
        yearsFrom1600 / 4 - yearsFrom1600 / 100 + yearsFrom1600 / 400 + if (!isLeapYear) 1 else 0
    val firstJanuaryDay =
        DayOfWeek.fromValue((firstJanuary1600.value + yearsFrom1600 + leapYearsFrom1600) % 7)

    val dayInMonth = when (month) {
        2 -> if (isLeapYear) 29 else 28
        1, 3, 5, 7, 8, 10, 12 -> 31
        else -> 30
    }


    // 1/1/2024 -> (1/1/2024 +  0) % 7
    // 1/2/2024 -> (1/1/2024 + 31) % 7
    // 1/3/2024 -> (1/1/2024 + (61  - 1)) % 7
    // 1/4/2024 -> (1/1/2024 + (92  - 1)) % 7
    // 1/5/2024 -> (1/1/2024 + (122 - 1)) % 7
    // but! (wa #9)
    // 1/9/2024 -> in July & August are 31 days
    // 1/10/2024 -> in September are 30 days
    val firstMonthDayOfWeek =
        DayOfWeek.fromValue(
            (firstJanuaryDay.value +
                    if (month % 2 != 0) {
                        61 * (month / 2)
                    } else {
                        61 * ((month - 1) / 2) + 31
                    } -
                    if (month > 2) {
                        if (isLeapYear) 1 else 2
                    } else { 0 } +
                    if (month > 8) { // i f*cking hate calendar creators
                        if (month % 2 != 0) 1 else 0
                    } else 0) % 7
        )

    val calendar = Array(7) { mutableListOf<Int>() }

    var currentDay = firstMonthDayOfWeek
    for (calendarDay in 1..dayInMonth) {
        calendar[currentDay.value].add(calendarDay)
        currentDay = currentDay.increase()
    }

    // output
    val firstColLimit = calendar[DayOfWeek.SUNDAY.value].first()

    for (i in calendar.indices) {                               // what's the hell is going there?
        val calendarDayOfWeek = calendar[i]
        println(buildString {
            append(DayOfWeek.fromValue(i).alias, ' ')
            if (calendarDayOfWeek.first() > firstColLimit) {
                append("     ")
            }
            for (calendarDay in calendarDayOfWeek) {
                if (calendarDay == day) {
                    append("[${"%2d".format(calendarDay)}] ")
                } else {
                    append(" ${"%2d".format(calendarDay)}  ")
                }
            }
        })
    }
}