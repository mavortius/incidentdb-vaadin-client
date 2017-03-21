package br.com.proinde.incidentdb.client.security;

public class RoleAuthority {
    public static final String OPERATOR = "OPERATOR";
    public static final String READER = "READER";

    public enum Authority {
        ADMIN("Administrator"),
        OPERATOR("Operator"),
        READER("Reader");

        private String label;

        Authority(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}
