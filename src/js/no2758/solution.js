/** 
 * @return {string}
 */
Date.prototype.nextDay = function () {
    let day = this.getDate()
    let month = this.getMonth()
    let year = this.getFullYear()
    let arr = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    if (year % 4 === 0 && year % 100 != 0) {
        arr[1] = 29
    }
    if (day == arr[month]) {
        day = 0
        if (++month == 12) {
            year++
            month = 0
        }
    }
    return year + '-' + (++month < 10 ? '0' + month : month) + '-' + (++day < 10 ? '0' + day : day)

}