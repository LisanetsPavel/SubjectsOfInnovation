/**
 * Created by pc9 on 02.06.16.
 */
mainApp.service('shareService', function(){
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


