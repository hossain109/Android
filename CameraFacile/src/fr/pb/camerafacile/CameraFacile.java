package fr.pb.camerafacile;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class CameraFacile extends Activity implements OnClickListener {

	private Button buttonPrendreUnePhoto;

	private static final int MEDIA_TYPE_IMAGE = 1;
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
	private Uri fileUri;

	/**
	 *
	 * type n'est pas utilise pour l'instant
	 * permettrait de distinguer photo et video
	 *
	 * @param type
	 * @return
	 */
	private static Uri getOutputMediaFileUri(int type) {
		return Uri.fromFile(getOutputMediaFile(type));
	}

	/**
	 *
	 * type n'est pas utilise pour l'instant
	 * permettrait de distinguer photo et video
	 *
	 * @param type
	 * @return
	 */
	private static File getOutputMediaFile(int type) {

		// Recuperation ou
		// Creation d'un dossier dans /mnt/sdcard/Pictures/
		File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MesPhotos");

		if (!mediaStorageDir.exists()) {
			if (!mediaStorageDir.mkdirs()) {
				Log.d("MesPhotos", "Impossible de creer le dossier");
				return null;
			}
		}

		// Creation du nom de la photo
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		// Creation du fichier ... vide
		// mediaStorageDir.getPath() + File.separator renvoie
		// /mnt/sdcard/Pictures/
		File mediaFile = new File(mediaStorageDir.getPath() + File.separator
				+ "IMG_" + timeStamp + ".jpg");

		return mediaFile;
	} // / getOutputMediaFile

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.camera_facile);

		buttonPrendreUnePhoto = (Button) findViewById(R.id.buttonPrendreUnePhoto);
		buttonPrendreUnePhoto.setOnClickListener(this);

	} // / onCreate

	@Override
	public void onClick(View v) {

		// Cree une intention pour la prise de photo
		// et renvoie le controle a l'appelant
		Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

		// Cree un fichier vide pour sauvegarder la photo
		fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);

		// Ajoute un extra a l'intention :
		// le fichier ou sera sauvegarder la photo
		intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

		// Demarre l'Intention de capture d'image
		startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

	} // / onClick
} // / class CameraFacile