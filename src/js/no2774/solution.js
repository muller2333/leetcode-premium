/**
 * @param {number} target
 * @return {number}
 */
Array.prototype.upperBound = function (target) {
    let length = this.length;
    let i = 0;
    let j = this.length - 1;
    while (i <= j) {
        let mid = Math.floor((i + j) / 2);
        if (this[mid] === target) {
            i = mid;
            j = length - 1;
            while (i <= j) {
                mid = Math.floor((i + j) / 2);
                if (this[mid] == target) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
            return j;
        } else if (this[mid] > target) {
            j = mid - 1;
        } else {
            i = mid + 1;
        }
    }
    return -1;
};
