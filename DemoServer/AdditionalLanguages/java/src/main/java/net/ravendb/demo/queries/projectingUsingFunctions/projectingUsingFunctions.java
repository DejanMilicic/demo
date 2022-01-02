//region Usings
import net.ravendb.client.documents.session.IDocumentSession;
import net.ravendb.client.documents.session.IRawDocumentQuery;
//endregion
import net.ravendb.demo.common.DocumentStoreHolder;



import java.util.List;

public class projectingUsingFunctions {

    //region Demo
    public static class Employee {
        public String FullName;
        public String Title;
    }
    //endregion


    public List<Employee> run() {
        List<Employee> projectedResults;
        //region Demo
        try (IDocumentSession session = DocumentStoreHolder.store.openSession()) {
        //region Step_1
            IRawDocumentQuery<Employee> projectedQueryWithFunctions = session.advanced().rawQuery(Employee.class,
        //endregion
        //region Step_2
                    "declare function output(employee) {" +
                    "var formatName  = function(employee) { return 'Full Name: ' + employee.FirstName + ' ' + employee.LastName; };" +
                    "var formatTitle = function(employee) { return 'Title: ' + employee.Title };" +
                    "return { FullName : formatName(employee), Title : formatTitle(employee) };" +
                    "}"+
        //endregion
        //region Step_3
                    "from Employees as employee select output(employee)");
        //endregion
        //region Step_4
             projectedResults = projectedQueryWithFunctions.toList();
            //endregion
        //endregion
    }
        return projectedResults;
}

