import android.os.AsyncTask;

class RequestHandler extends AsyncTask<Void, Void, Boolean> {

    private final String mRequest;

    RequestHandler(String request_id) {
        mRequest = request_id;
    }

    @Override
    protected Boolean doInBackground (Void...params) {

        
        return null;
    }
}
