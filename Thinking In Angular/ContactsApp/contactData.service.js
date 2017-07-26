(function () {
    var app = angular.module("ContactsApp");
    app.service("ContactDataSvc", function () {
        //var this = {};
        this.contacts = [
            {
                "gender": "male",
                "name": {
                    "title": "mr",
                    "first": "ben",
                    "last": "simpson"
                },
                "location": {
                    "street": "4099 robinson rd",
                    "city": "wichita falls",
                    "state": "minnesota",
                    "postcode": 12517
                },
                "email": "ben.simpson@example.com",
                "login": {
                    "username": "crazyelephant723",
                    "password": "21212121",
                    "salt": "kFTvShib",
                    "md5": "f7a9b70d9034dcefebdb385013ef21a5",
                    "sha1": "d5486cc29c75ba533d73e1fe13de7d6e5ac2cde4",
                    "sha256": "bf6dd04af598c404cede8fbda2d924eb021282a321b1246a64995fd4081c2514"
                },
                "dob": "1986-04-17 17:46:12",
                "registered": "2003-01-28 01:19:03",
                "phone": "(185)-140-7976",
                "cell": "(426)-915-7761",
                "id": {
                    "name": "SSN",
                    "value": "333-01-6629"
                },
                "picture": {
                    "large": "https://randomuser.me/api/portraits/men/66.jpg",
                    "medium": "https://randomuser.me/api/portraits/med/men/66.jpg",
                    "thumbnail": "https://randomuser.me/api/portraits/thumb/men/66.jpg"
                },
                "nat": "US"
            },
            {
                "gender": "female",
                "name": {
                    "title": "miss",
                    "first": "olivia",
                    "last": "meunier"
                },
                "location": {
                    "street": "8779 avenue debrousse",
                    "city": "caen",
                    "state": "martinique",
                    "postcode": 69996
                },
                "email": "olivia.meunier@example.com",
                "login": {
                    "username": "lazysnake753",
                    "password": "apple123",
                    "salt": "QHw7iwso",
                    "md5": "c5b6c459dd2dbb2a88f281cef3cb8152",
                    "sha1": "cfae9833772a8ca8922b5e525a4fd02f1318da18",
                    "sha256": "14b78b4b9b857642c534e739f0b77de28daad7c9f074e0ad970437bc338a8400"
                },
                "dob": "1951-12-02 22:42:31",
                "registered": "2003-10-11 02:35:06",
                "phone": "05-91-40-65-63",
                "cell": "06-36-52-21-78",
                "id": {
                    "name": "INSEE",
                    "value": "2511104596963 64"
                },
                "picture": {
                    "large": "https://randomuser.me/api/portraits/women/63.jpg",
                    "medium": "https://randomuser.me/api/portraits/med/women/63.jpg",
                    "thumbnail": "https://randomuser.me/api/portraits/thumb/women/63.jpg"
                },
                "nat": "FR"
            },
            {
                "gender": "female",
                "name": {
                    "title": "ms",
                    "first": "ethel",
                    "last": "knight"
                },
                "location": {
                    "street": "6602 w gray st",
                    "city": "scurry",
                    "state": "south carolina",
                    "postcode": 86251
                },
                "email": "ethel.knight@example.com",
                "login": {
                    "username": "beautifulladybug678",
                    "password": "boricua",
                    "salt": "irtuXQt4",
                    "md5": "9707e4323843dccbdd91b70dccac0a37",
                    "sha1": "3adbb900372777664b0e98c7fe1186821251a7c7",
                    "sha256": "ee8b94a45cd20e62d4e8653873653362fd8223ccef1a581ba8e20b8fd09f0b20"
                },
                "dob": "1987-03-16 13:39:57",
                "registered": "2007-10-02 02:06:42",
                "phone": "(379)-607-9820",
                "cell": "(734)-191-6176",
                "id": {
                    "name": "SSN",
                    "value": "945-25-0612"
                },
                "picture": {
                    "large": "https://randomuser.me/api/portraits/women/88.jpg",
                    "medium": "https://randomuser.me/api/portraits/med/women/88.jpg",
                    "thumbnail": "https://randomuser.me/api/portraits/thumb/women/88.jpg"
                },
                "nat": "US"
            },
            {
                "gender": "female",
                "name": {
                    "title": "miss",
                    "first": "isla",
                    "last": "annala"
                },
                "location": {
                    "street": "8411 mannerheimintie",
                    "city": "veteli",
                    "state": "uusimaa",
                    "postcode": 11523
                },
                "email": "isla.annala@example.com",
                "login": {
                    "username": "lazygorilla824",
                    "password": "steel",
                    "salt": "BvqvF9S1",
                    "md5": "e9b3f0ab5b235f6a9a30f652d8ae93a6",
                    "sha1": "51a14edd096899f93e0800d6a6d4eb3f998dec5d",
                    "sha256": "20b1b3d0e6ba6203e1803c12ca74a860acf4af0e33be35a5d59911809f5a922e"
                },
                "dob": "1991-04-15 00:44:35",
                "registered": "2014-08-03 16:29:58",
                "phone": "05-526-996",
                "cell": "041-736-83-82",
                "id": {
                    "name": "HETU",
                    "value": "491-868P"
                },
                "picture": {
                    "large": "https://randomuser.me/api/portraits/women/14.jpg",
                    "medium": "https://randomuser.me/api/portraits/med/women/14.jpg",
                    "thumbnail": "https://randomuser.me/api/portraits/thumb/women/14.jpg"
                },
                "nat": "FI"
            },
            {
                "gender": "male",
                "name": {
                    "title": "mr",
                    "first": "ken",
                    "last": "young"
                },
                "location": {
                    "street": "8204 the green",
                    "city": "portlaoise",
                    "state": "meath",
                    "postcode": 12714
                },
                "email": "ken.young@example.com",
                "login": {
                    "username": "redladybug720",
                    "password": "rrrr",
                    "salt": "aKnPlGLM",
                    "md5": "c0d1ccadcbe2dcd8d3fbf306e22a831e",
                    "sha1": "e56b7c997ebe7d9c3b11d7653284ae01f3671faa",
                    "sha256": "a1426c5443aff0e2de037b79ebe67cf145549449e4f27671b0910a64a0ef2c7c"
                },
                "dob": "1985-12-22 15:17:47",
                "registered": "2012-11-04 18:14:46",
                "phone": "061-978-0034",
                "cell": "081-046-1098",
                "id": {
                    "name": "PPS",
                    "value": "8788351T"
                },
                "picture": {
                    "large": "https://randomuser.me/api/portraits/men/74.jpg",
                    "medium": "https://randomuser.me/api/portraits/med/men/74.jpg",
                    "thumbnail": "https://randomuser.me/api/portraits/thumb/men/74.jpg"
                },
                "nat": "IE"
            },
            {
                "gender": "male",
                "name": {
                    "title": "mr",
                    "first": "matthew",
                    "last": "liu"
                },
                "location": {
                    "street": "4191 york st",
                    "city": "windsor",
                    "state": "ontario",
                    "postcode": 60016
                },
                "email": "matthew.liu@example.com",
                "login": {
                    "username": "tinykoala331",
                    "password": "racer",
                    "salt": "H9BR6F7N",
                    "md5": "e079a7a501cf3198310c3d64020182f8",
                    "sha1": "eb20d3908c686dc2dfcea1dd8db7050ce558c829",
                    "sha256": "a6291f584591e687f38388898aae4c35db678aca5421a8239233dbe2d7ec055c"
                },
                "dob": "1990-12-22 17:16:47",
                "registered": "2012-07-20 00:37:19",
                "phone": "159-313-9309",
                "cell": "518-284-9555",
                "id": {
                    "name": "",
                    "value": null
                },
                "picture": {
                    "large": "https://randomuser.me/api/portraits/men/1.jpg",
                    "medium": "https://randomuser.me/api/portraits/med/men/1.jpg",
                    "thumbnail": "https://randomuser.me/api/portraits/thumb/men/1.jpg"
                },
                "nat": "CA"
            }

        ];

        //return this;
    });
})();   