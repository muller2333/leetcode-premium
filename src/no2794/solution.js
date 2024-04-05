/**
 * @param {Array} keysArr
 * @param {Array} valuesArr
 * @return {Object}
 */
var createObject = function (keysArr, valuesArr) {
    let res = {}
    for (let i = 0; i < keysArr.length; i++) {
        if (!(keysArr[i] + '' in res)) {
            res[keysArr[i] + ''] = valuesArr[i]
        }
    }
    return res;
};