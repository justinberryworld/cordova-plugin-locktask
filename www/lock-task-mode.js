
var exec = require('cordova/exec');

var lockTaskMode = function() {};

lockTaskMode.setLockTaskEnabled = (successCallback, errorCallback) => {
    exec(successCallback, errorCallback, "LockTaskMode", "setLockTaskEnabled");
}

lockTaskMode.setLockTaskPackages = (successCallback, errorCallback) => {
    exec(successCallback, errorCallback, "LockTaskMode", "setLockTaskPackages");
}

module.exports = lockTaskMode;