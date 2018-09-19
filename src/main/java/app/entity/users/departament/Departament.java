package app.entity.users.departament;

public enum Departament {
    DGM{
        @Override
        public String getFullName() {
            return "Служба главного механика";
        }
    };
    public abstract String getFullName();
}
