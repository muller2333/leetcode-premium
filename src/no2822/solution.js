/**
 * @param {Object|Array} obj
 * @return {Object}
 */
var invertObject = function (obj) {
    let res = {}
    for (let key in obj) {
        if (res[obj[key]]) {
            if (res[obj[key]] instanceof Array) {
                res[obj[key]] = [...res[obj[key]], key]
            } else {
                res[obj[key]] = [res[obj[key]], key]
            }
        } else {
            res[obj[key]] = key
        }
    }
    return res
};