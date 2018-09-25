package app.entity.departament;

public enum EnumDepartament {
    DGM{
        @Override
        public String getFullName() {
            return "Служба главного механика";
        }
    };
    public abstract String getFullName();
}
