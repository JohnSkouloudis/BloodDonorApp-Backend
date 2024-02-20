package gr.hua.dit.ds.BloodDonorApp.payload.request;


import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

    public class UpdatePersonalInfoRequest {
        @Size(min = 3, max = 20)
        private String username;

        @Size(max = 50)
        @Email
        private String email;

        @Column
        private String phoneNumber;

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }


        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

    }


