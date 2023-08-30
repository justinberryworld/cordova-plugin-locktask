
var cordova = require('cordova');

/**
 * This represents the lock task mode.
 * @constructor
 */
function LockTaskMode() {
    greet = (name, successCallback, errorCallback) => {
        cordova.exec(successCallback, errorCallback, "Hello", "greet", [name]);
    }
}


module.exports = new LockTaskMode();