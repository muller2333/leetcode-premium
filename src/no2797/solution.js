/**
 * @param {Function} fn
 * @param {Array} args
 * @return {Function}
 */
var partial = function (fn, args) {

    return function (...restArgs) {
        let arr = []
        let i = 0;
        for (let e of args) {
            if (e === '_') {
                arr.push(restArgs[i++])
            } else {
                arr.push(e)
            }
        }
        return fn(...arr, ...restArgs.slice(i))
    }
};