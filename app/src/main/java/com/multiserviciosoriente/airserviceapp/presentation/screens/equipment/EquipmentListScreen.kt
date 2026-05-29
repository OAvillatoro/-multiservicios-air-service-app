package com.multiserviciosoriente.airserviceapp.presentation.screens.equipment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EquipmentListScreen(
    onBackClick: () -> Unit,
    onAddEquipmentClick: () -> Unit,
    onRequestServiceClick: () -> Unit,
    onHistoryClick: () -> Unit
) {
    val primaryBlue = Color(0xFF003F99)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF9800)
    val green = Color(0xFF00865A)
    val textDark = Color(0xFF17213D)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FD))
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "‹",
                    color = darkBlue,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onBackClick() }
                )

                Column(
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    Text(
                        text = "Mis Equipos",
                        color = textDark,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Consulta y administra tus equipos registrados",
                        color = Color(0xFF5D6678),
                        fontSize = 14.sp
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Box {
                    Text(
                        text = "🔔",
                        fontSize = 28.sp
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(19.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFE53935)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "3",
                            color = Color.White,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 4.dp
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            Brush.horizontalGradient(
                                listOf(
                                    darkBlue,
                                    primaryBlue
                                )
                            )
                        )
                        .padding(20.dp)
                ) {
                    Column {
                        Text(
                            text = "Equipos de aire acondicionado",
                            color = Color.White,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Mantén actualizado el registro de tus equipos para facilitar solicitudes de mantenimiento preventivo o correctivo.",
                            color = Color.White.copy(alpha = 0.92f),
                            fontSize = 15.sp,
                            lineHeight = 21.sp
                        )

                        Spacer(modifier = Modifier.height(14.dp))

                        Box(
                            modifier = Modifier
                                .width(150.dp)
                                .height(5.dp)
                                .background(orange, RoundedCornerShape(50.dp))
                        )
                    }

                    Text(
                        text = "❄️",
                        color = Color.White,
                        fontSize = 54.sp,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                EquipmentSummaryCard(
                    value = "3",
                    label = "Equipos\nregistrados",
                    icon = "❄️",
                    color = primaryBlue,
                    modifier = Modifier.weight(1f)
                )

                EquipmentSummaryCard(
                    value = "2",
                    label = "Mantenimientos\npróximos",
                    icon = "📅",
                    color = green,
                    modifier = Modifier.weight(1f)
                )

                EquipmentSummaryCard(
                    value = "1",
                    label = "Solicitud\npendiente",
                    icon = "📋",
                    color = orange,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Listado de equipos",
                    color = textDark,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                TextButton(onClick = onAddEquipmentClick) {
                    Text(
                        text = "⊕ Agregar",
                        color = primaryBlue,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            EquipmentItemCard(
                brand = "Samsung",
                model = "WindFree 12,000 BTU",
                type = "Minisplit Inverter",
                serial = "SA12WF2024A001256",
                location = "Sala principal",
                lastMaintenance = "15 abr. 2024",
                nextMaintenance = "15 oct. 2024",
                status = "Activo",
                icon = "❄️",
                primaryBlue = primaryBlue,
                green = green,
                onEditClick = onAddEquipmentClick,
                onRequestServiceClick = onRequestServiceClick,
                onHistoryClick = onHistoryClick
            )

            Spacer(modifier = Modifier.height(12.dp))

            EquipmentItemCard(
                brand = "LG",
                model = "Dual Inverter 18,000 BTU",
                type = "Minisplit Inverter",
                serial = "LG18DI2024B003441",
                location = "Habitación principal",
                lastMaintenance = "20 feb. 2024",
                nextMaintenance = "20 ago. 2024",
                status = "Activo",
                icon = "▤",
                primaryBlue = primaryBlue,
                green = green,
                onEditClick = onAddEquipmentClick,
                onRequestServiceClick = onRequestServiceClick,
                onHistoryClick = onHistoryClick
            )

            Spacer(modifier = Modifier.height(12.dp))

            EquipmentItemCard(
                brand = "Midea",
                model = "9,000 BTU Frío/Calor",
                type = "Ventana",
                serial = "MD09FC2024C007811",
                location = "Oficina",
                lastMaintenance = "10 mar. 2024",
                nextMaintenance = "10 sep. 2024",
                status = "Activo",
                icon = "▣",
                primaryBlue = primaryBlue,
                green = green,
                onEditClick = onAddEquipmentClick,
                onRequestServiceClick = onRequestServiceClick,
                onHistoryClick = onHistoryClick
            )

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFEAF2FF),
                shape = RoundedCornerShape(14.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "ℹ️",
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "Desde esta pantalla puedes consultar el historial del equipo, editar información o crear una solicitud de mantenimiento.",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp,
                        lineHeight = 19.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }

        EquipmentBottomActions(
            primaryBlue = primaryBlue,
            onBackClick = onBackClick,
            onAddEquipmentClick = onAddEquipmentClick
        )
    }
}

@Composable
private fun EquipmentSummaryCard(
    value: String,
    label: String,
    icon: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.height(122.dp),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        shadowElevation = 3.dp
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(color.copy(alpha = 0.13f)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = icon,
                    fontSize = 22.sp
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = value,
                color = color,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = label,
                color = Color(0xFF17213D),
                fontSize = 12.sp,
                textAlign = TextAlign.Center,
                lineHeight = 15.sp
            )
        }
    }
}

@Composable
private fun EquipmentItemCard(
    brand: String,
    model: String,
    type: String,
    serial: String,
    location: String,
    lastMaintenance: String,
    nextMaintenance: String,
    status: String,
    icon: String,
    primaryBlue: Color,
    green: Color,
    onEditClick: () -> Unit,
    onRequestServiceClick: () -> Unit,
    onHistoryClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(18.dp),
        shadowElevation = 3.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .size(82.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFFEAF2FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = icon,
                        color = primaryBlue,
                        fontSize = 35.sp
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(start = 14.dp)
                        .weight(1f)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = brand,
                            color = Color(0xFF17213D),
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Surface(
                            color = green.copy(alpha = 0.13f),
                            shape = RoundedCornerShape(50.dp)
                        ) {
                            Text(
                                text = status,
                                color = green,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "Modelo: $model",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Tipo: $type",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Serie: $serial",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp
                    )

                    Text(
                        text = "Ubicación: $location",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp
                    )
                }

                Text(
                    text = "⋮",
                    color = Color(0xFF17213D),
                    fontSize = 28.sp
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Divider()

            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Último mantenimiento",
                        color = Color(0xFF5D6678),
                        fontSize = 13.sp
                    )

                    Text(
                        text = "📅 $lastMaintenance",
                        color = Color(0xFF17213D),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Próximo mantenimiento",
                        color = Color(0xFF5D6678),
                        fontSize = 13.sp
                    )

                    Text(
                        text = "📅 $nextMaintenance",
                        color = green,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(13.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedButton(
                    onClick = onHistoryClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Historial",
                        color = primaryBlue,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = onRequestServiceClick,
                    modifier = Modifier.weight(1.4f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Solicitar servicio",
                        color = primaryBlue,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = onEditClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Editar",
                        color = primaryBlue,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun EquipmentBottomActions(
    primaryBlue: Color,
    onBackClick: () -> Unit,
    onAddEquipmentClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 8.dp),
        color = Color.White,
        shape = RoundedCornerShape(18.dp),
        shadowElevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(74.dp)
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedButton(
                onClick = onBackClick,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Volver",
                    color = primaryBlue,
                    fontWeight = FontWeight.Bold
                )
            }

            Button(
                onClick = onAddEquipmentClick,
                modifier = Modifier.weight(1.4f),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryBlue
                )
            ) {
                Text(
                    text = "Agregar equipo",
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}