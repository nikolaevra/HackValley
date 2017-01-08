var express = require('express'),
config = require('./config/config');

var app = express();
var admin = require("firebase-admin");

var serviceAccount = require("sdk.json");

module.exports = require('./config/express')(app, config);

app.listen(config.port, function () {
  console.log('Express server listening on port ' + config.port);
});

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://hackvalley-5be01.firebaseio.com/",
});

// writes data to database (WILL OVERWRITE EVERYTHING)
/*admin.database().ref('/').set({
    beacon: "ThisBeaconIsCreatedFromNodeServer"
});*/

// will update the data at the given location
// more info at https://firebase.google.com/docs/database/web/read-and-write#update_specific_fields

var postData = { creator: "Subhan N" };
var updates = {};
updates['/beacons/beacon1/chats/chat1/'] = postData;
admin.database().ref().update(updates);
