(function () {
    var app = angular.module("ContactsApp");
    app.controller("ContactsCtrl", ContactsCtrl);



    function ContactsCtrl(ContactDataSvc) {

        this.contacts = ContactDataSvc.contacts;

        this.selectContact = function (index) {
            this.selectedContact = this.contacts[index];
        }


    }
})();