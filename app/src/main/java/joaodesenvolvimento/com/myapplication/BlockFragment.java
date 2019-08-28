package joaodesenvolvimento.com.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.ag.floatingactionmenu.FabWithOptions;
import com.github.ag.floatingactionmenu.OptionsFabLayout;

public class BlockFragment extends Fragment {

    OptionsFabLayout fabWithOptions;
    Context contexto;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragmento_block, container, false);

        fabWithOptions = (OptionsFabLayout) view.findViewById(R.id.fab_l);

        //Set mini fab's colors.
        fabWithOptions.setMiniFabsColors(
                R.color.colorPrimary,
                R.color.green_fab);

        //Set main fab clicklistener.
        fabWithOptions.setMainFabOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fabWithOptions.isOptionsMenuOpened()){
                    fabWithOptions.closeOptionsMenu();
                }
            }
        });

        //Set mini fabs clicklisteners.
        fabWithOptions.setMiniFabSelectedListener(new OptionsFabLayout.OnMiniFabSelectedListener() {
            @Override
            public void onMiniFabSelected(MenuItem fabItem) {
                switch (fabItem.getItemId()) {
                    case R.id.activity_novo_cliente_btnSalvar:
                        Toast.makeText(
                                getActivity(),
                                fabItem.getTitle() + " salvar!",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.activity_novo_clente_limpar:
                        Toast.makeText(getActivity(),
                                fabItem.getTitle() + "limpar!",
                                Toast.LENGTH_SHORT).show();
                    default:
                        break;
                }
            }

        });
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        contexto = getActivity();
    }
}
