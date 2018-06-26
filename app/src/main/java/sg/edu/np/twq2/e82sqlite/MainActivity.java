package sg.edu.np.twq2.e82sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText productBox;
    EditText quantityBox;
    TextView idView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productBox = findViewById(R.id.txtName);
        quantityBox = findViewById(R.id.txtQuantity);
        idView = findViewById(R.id.txtId);
    }

    //ADD
    public void newProduct (View view) {
        DBHelper dbHandler = new DBHelper(this, null, null, 1);
        int quantity = Integer.parseInt(quantityBox.getText().toString());
        Product product = new Product(productBox.getText().toString(), quantity);
        dbHandler.addProduct(product);
        productBox.setText("");
        quantityBox.setText("");
    }

    //FIND
    public void lookupProduct (View view) {
        DBHelper dbHandler = new DBHelper(this, null, null, 1);
        Product product =
                dbHandler.findProduct(productBox.getText().toString());
        if (product != null) {
            idView.setText(String.valueOf(product.getId()));
            quantityBox.setText(String.valueOf(product.getQuantity()));
        } else {
            idView.setText("No Match Found");
        }
    }

    //DELETE
    public void removeProduct (View view) {
        DBHelper dbHandler = new DBHelper(this, null, null, 1);
        boolean result = dbHandler.deleteProduct(
                productBox.getText().toString());
        if (result)
        {
            idView.setText("Record Deleted");
            productBox.setText("");
            quantityBox.setText("");
        }
        else {
            idView.setText("No Match Found");
        }
    }
}
