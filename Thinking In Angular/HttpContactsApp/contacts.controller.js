(function () {
    var app = angular.module("ContactsApp");
    app.controller("ContactsCtrl", ContactsCtrl);



    function ContactsCtrl(ContactDataSvc) {

        var self = this;
        self.editMode = false;
        self.addMode = false;
        ContactDataSvc.getContacts()
            .then(function (data) {
                self.contacts = data;
            })



        this.selectContact = function (index) {
            this.selectedContact = this.contacts[index];
            self.successMessage = undefined;
            self.failureMessage = undefined;
        }

        this.toggleEditMode = function () {
            this.editMode = !this.editMode;
        }

        this.saveUser = function () {
            this.toggleEditMode();
            var userData = this.selectedContact;

            if (self.addMode) {
                ContactDataSvc.createUser(userData)
                    .then(function () {
                        self.successMessage = "Data successfully updated!";
                    },
                    function () {
                        self.failureMessage = "There was an error! Please try again!";
                    }
                    );
                    self.addMode = false;
            }
            
            else {

                ContactDataSvc.saveUser(userData)
                    .then(function () {
                        self.successMessage = "Data successfully updated!";
                    },
                    function () {
                        self.failureMessage = "There was an error! Please try again!";
                    }
                    );
            }
        }

        this.addContact = function () {
            self.addMode = true;
            this.selectedContact = {
                "id": new Date().toTimeString()
            };
            this.editMode = true;
        }


    }
})();