package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.FancyDatabase;
import put.io.students.fancylibrary.database.IFancyDatabase;
import static org.mockito.Mockito.*;

public class ExpenseRepositoryTest {
    private ExpenseRepository expenseRepository;

    @Test
    void loadExpenses() {
        IFancyDatabase database = new MyDatabase();
        expenseRepository = new ExpenseRepository(database);
        assertArrayEquals(expenseRepository.getExpenses().toArray(),List.of().toArray() );

    }

}
