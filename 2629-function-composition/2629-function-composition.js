/**
 * @param {Function[]} functions
 * @return {Function}
 */
var compose = function (functions) {
  const fn = function (x) {
    if (functions.length === 0) return x;

    let result = 0;
    for (let i = functions.length - 1; i >= 0; i--) {
      if (i >= 0) {
        result = functions[i](x);
        x = result
      }
      
    }
    return result;
  };
  return fn;
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */