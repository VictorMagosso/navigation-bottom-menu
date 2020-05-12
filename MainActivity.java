
public class PrincipalActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_principal );
        
        //biblioteca androidx
        BottomNavigationView bottomNav = findViewById( R.id.bottom_navigation ); //definir um id pro navigation bottom
        bottomNav.setOnNavigationItemSelectedListener( navListener );
        
        //container que terá o bottom navigation. Nesse caso, estou indicando que por padrão, ao iniciar o app, abrirá primeiro o HomeFragment
        getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container, new HomeFragment() )
                .commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    
                    //criação da view dos fragments
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.nav_objetivo:
                            selectedFragment = new ObjetivoFragment();
                            break;

                        case R.id.nav_atualidades:
                            selectedFragment = new AtualidadeFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace( R.id.fragment_container, selectedFragment )
                            .commit();


                    return true;
         }
    };
}
