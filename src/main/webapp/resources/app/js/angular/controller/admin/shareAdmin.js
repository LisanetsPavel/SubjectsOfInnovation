/**
 * Created by pc9 on 09.06.16.
 */
adminApp.service('shareAdmin', function(){
    var objectValue = null

    return {
        getOrg: function () {
            return objectValue;
        },
        setOrg: function (value) {
            objectValue = value;
        }
    }

});
