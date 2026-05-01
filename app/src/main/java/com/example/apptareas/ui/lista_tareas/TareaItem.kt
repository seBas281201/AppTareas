package com.example.apptareas.ui.lista_tareas

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.apptareas.data.local.entity.TareaEntity

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TareaItem(
    tarea: TareaEntity,
    onDelete: (TareaEntity) -> Unit,
    onEditar: (TareaEntity) -> Unit,
    onDetalles : (TareaEntity) -> Unit
) {

    var showDialog by remember {
        mutableStateOf(false)
    }

    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        modifier = Modifier
            .width(300.dp)
            .padding(10.dp)
            .clickable{
                onDetalles(tarea)
            }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                text = tarea.titulo,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(5.dp))


            Text(
                text = tarea.descripcion ?: "Sin descripción",
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = if (tarea.completada) "Tarea completada" else "Tarea pendiente",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = tarea.fechaDeCreacion,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )

                Spacer(modifier = Modifier.width(10.dp))

                IconButton(
                    onClick = {
                        showDialog = true
                    },
                    modifier = Modifier.minimumInteractiveComponentSize()
                ) {

                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Eliminar tarea",
                        modifier = Modifier
                            .size(20.dp)
                    )

                }

                IconButton(
                    onClick = {
                        onEditar(tarea)
                    },
                    modifier = Modifier.minimumInteractiveComponentSize()
                ) {

                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Editar tarea",
                        modifier = Modifier
                            .size(20.dp),
                    )

                }
            }

            if(showDialog){
                AlertDialog(
                    onDismissRequest = {
                      showDialog = false
                    },
                    text = {
                        Text(
                            text = "¿Estás seguro de que quieres eliminar esta tarea?",
                        )
                    },
                    title = {
                        Text(
                            text = "Eliminar tarea"
                        )
                    },
                    confirmButton = {
                        TextButton(
                            onClick = {
                                onDelete(tarea)
                                Toast.makeText(
                                    context,
                                    "Tarea eliminada con éxito.",
                                    Toast.LENGTH_SHORT
                                ).show()
                                showDialog = false

                            }
                        ) {
                            Text(
                                text = "Eliminar",
                                color = MaterialTheme.colorScheme.error
                            )
                        }
                    },
                    dismissButton = {
                        TextButton(
                            onClick = {
                                showDialog = false

                            }
                        ) {
                            Text(
                                text = "Cancelar",
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.surface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    textContentColor = MaterialTheme.colorScheme.onSurface,

                )
            }

        }

        Spacer(modifier = Modifier.height(13.dp))

    }
}