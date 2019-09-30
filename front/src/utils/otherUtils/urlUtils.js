/**
 * 将url中参数转换成对象
 * todo:ur
 * @param {*} url
 */
export const transformToJson = function (url) {
  let data = {}
  let params = url.split('&');
  for (let i = 0, j = params.length; i < j; i++) {
    let param = params[i].split('=');
    data[param[0]] = encodeURI(param[1]);
  }
  return data;
}
/**
 * 读取url中参数的值
 * @param {*} url
 * @param {*} key
 */
export const readUrlField = function (url, key) {
  let params = url.split('&');
  for (let i = 0, j = params.length; i < j; i++) {
    let param = params[i].split('=');
    if (param[0] == key) {
      return param[1];
    }
  }
  return "";
}
