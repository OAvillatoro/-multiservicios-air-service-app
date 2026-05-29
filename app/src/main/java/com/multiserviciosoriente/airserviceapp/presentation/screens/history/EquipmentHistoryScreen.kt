package com.multiserviciosoriente.airserviceapp.presentation.screens.history

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
fun EquipmentHistoryScreen(
    onBackClick: () -> Unit
) {
    val primaryBlue = Color(0xFF0047C7)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF6F00)
    val green = Color(0xFF15803D)
    val textDark = Color(0xFF17213D)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FD))
            .navigationBarsPadding()
    ) {
        MobileHistoryTopBar(
            darkBlue = darkBlue,
            primaryBlue = primaryBlue,
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Inicio  ›  Equipos  ›  Historial",
                color = Color(0xFF4B5878),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(14.dp))

            HistoryHeaderCard(
                primaryBlue = primaryBlue,
                darkBlue = darkBlue,
                orange = orange,
                textDark = textDark,
                onBackClick = onBackClick
            )

            Spacer(modifier = Modifier.height(14.dp))

            EquipmentInfoCard(
                primaryBlue = primaryBlue,
                textDark = textDark
            )

            Spacer(modifier = Modifier.height(14.dp))

            FilterCard(
                primaryBlue = primaryBlue
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Servicios realizados",
                    color = textDark,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                Surface(
                    color = Color(0xFFEAF2FF),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text(
                        text = "4 registros",
                        color = primaryBlue,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            HistoryServiceCard(
                date = "21/05/2024",
                time = "09:30 AM",
                type = "Mantenimiento correctivo",
                typeColor = orange,
                technician = "Carlos Méndez",
                work = "Se reemplazó el capacitor del compresor. También se realizó limpieza de filtros, serpentín y bandeja de drenaje.",
                recommendation = "Realizar mantenimiento preventivo cada 6 meses y mantener filtros limpios.",
                amount = "$95.00",
                nextMaintenance = "21/11/2024",
                primaryBlue = primaryBlue,
                textDark = textDark
            )

            Spacer(modifier = Modifier.height(12.dp))

            HistoryServiceCard(
                date = "18/02/2024",
                time = "02:00 PM",
                type = "Mantenimiento preventivo",
                typeColor = green,
                technician = "Roberto Sánchez",
                work = "Limpieza general del equipo, revisión de conexiones eléctricas, verificación de presiones y consumo.",
                recommendation = "Seguir con mantenimiento preventivo cada 6 meses.",
                amount = "$80.00",
                nextMaintenance = "18/08/2024",
                primaryBlue = primaryBlue,
                textDark = textDark
            )

            Spacer(modifier = Modifier.height(12.dp))

            HistoryServiceCard(
                date = "10/11/2023",
                time = "10:30 AM",
                type = "Mantenimiento preventivo",
                typeColor = green,
                technician = "Ana Rodríguez",
                work = "Limpieza de filtros y serpentín. Revisión de gas refrigerante y pruebas de funcionamiento.",
                recommendation = "Mantener el área alrededor del equipo limpia y libre de obstrucciones.",
                amount = "$75.00",
                nextMaintenance = "10/05/2024",
                primaryBlue = primaryBlue,
                textDark = textDark
            )

            Spacer(modifier = Modifier.height(12.dp))

            HistoryServiceCard(
                date = "12/05/2023",
                time = "03:00 PM",
                type = "Mantenimiento correctivo",
                typeColor = orange,
                technician = "Roberto Sánchez",
                work = "El equipo no enfriaba correctamente. Se detectó fuga de gas y se recargó el sistema.",
                recommendation = "Monitorear nivel de enfriamiento y realizar mantenimiento preventivo en 6 meses.",
                amount = "$110.00",
                nextMaintenance = "12/11/2023",
                primaryBlue = primaryBlue,
                textDark = textDark
            )

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFEAF2FF),
                shape = RoundedCornerShape(14.dp)
            ) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.Top
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(primaryBlue),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "i",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 22.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Column {
                        Text(
                            text = "Información",
                            color = primaryBlue,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = "El próximo mantenimiento preventivo recomendado se calcula a partir de la fecha del último servicio realizado.",
                            color = Color(0xFF31415F),
                            fontSize = 13.sp,
                            lineHeight = 18.sp
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun MobileHistoryTopBar(
    darkBlue: Color,
    primaryBlue: Color,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(92.dp)
            .background(
                Brush.horizontalGradient(
                    listOf(darkBlue, primaryBlue)
                )
            )
            .padding(horizontal = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "‹",
                color = Color.White,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onBackClick() }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Historial del equipo",
                    color = Color.White,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Servicios realizados",
                    color = Color.White.copy(alpha = 0.88f),
                    fontSize = 14.sp
                )
            }

            Text(
                text = "📋",
                fontSize = 30.sp
            )
        }
    }
}

@Composable
private fun HistoryHeaderCard(
    primaryBlue: Color,
    darkBlue: Color,
    orange: Color,
    textDark: Color,
    onBackClick: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(18.dp),
        shadowElevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(18.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(54.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(primaryBlue),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "📋",
                        fontSize = 26.sp
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Historial del equipo",
                        color = textDark,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 25.sp
                    )

                    Text(
                        text = "Consulta los servicios realizados a este equipo.",
                        color = Color(0xFF5D6678),
                        fontSize = 14.sp,
                        lineHeight = 19.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = onBackClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = darkBlue
                    )
                ) {
                    Text(
                        text = "Volver",
                        fontWeight = FontWeight.Bold
                    )
                }

                OutlinedButton(
                    onClick = {},
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = primaryBlue
                    )
                ) {
                    Text(
                        text = "Exportar",
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(5.dp)
                    .background(orange, RoundedCornerShape(50.dp))
            )
        }
    }
}

@Composable
private fun EquipmentInfoCard(
    primaryBlue: Color,
    textDark: Color
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0xFFE1E6F0)),
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(68.dp)
                        .clip(RoundedCornerShape(14.dp))
                        .background(Color(0xFFEAF2FF)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "❄️",
                        fontSize = 34.sp
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "LG Dual Inverter 18,000 BTU",
                        color = primaryBlue,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 22.sp
                    )

                    Text(
                        text = "SN: LG18DI2023B009874",
                        color = Color(0xFF4B5878),
                        fontSize = 13.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Surface(
                        color = Color(0xFFDDF7E4),
                        shape = RoundedCornerShape(50.dp)
                    ) {
                        Text(
                            text = "Activo",
                            color = Color(0xFF15803D),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Divider(color = Color(0xFFE1E6F0))

            Spacer(modifier = Modifier.height(12.dp))

            InfoLine(
                label = "Tipo de equipo",
                value = "Minisplit Inverter"
            )

            InfoLine(
                label = "Marca",
                value = "LG"
            )

            InfoLine(
                label = "Ubicación",
                value = "Sala principal"
            )

            InfoLine(
                label = "Fecha de instalación",
                value = "10/11/2022"
            )

            InfoLine(
                label = "Propietario",
                value = "María López Torres · 7123-4567",
                valueColor = textDark
            )
        }
    }
}

@Composable
private fun InfoLine(
    label: String,
    value: String,
    valueColor: Color = Color(0xFF002B75)
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = label,
            color = Color(0xFF5D6678),
            fontSize = 13.sp,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = value,
            color = valueColor,
            fontSize = 13.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.End,
            modifier = Modifier.weight(1.2f)
        )
    }
}

@Composable
private fun FilterCard(
    primaryBlue: Color
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0xFFE1E6F0)),
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Filtros",
                color = Color(0xFF17213D),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(12.dp))

            FilterItem(
                label = "Tipo de mantenimiento",
                value = "Todos"
            )

            FilterItem(
                label = "Rango de fechas",
                value = "01/01/2023 - 21/05/2024"
            )

            FilterItem(
                label = "Técnico",
                value = "Todos"
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedButton(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Limpiar filtros",
                    color = primaryBlue,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
private fun FilterItem(
    label: String,
    value: String
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        color = Color(0xFFF7F9FD),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFD6DCE8))
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 11.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = label,
                    color = Color(0xFF5D6678),
                    fontSize = 12.sp
                )

                Text(
                    text = value,
                    color = Color(0xFF17213D),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Text(
                text = "⌄",
                color = Color(0xFF2F3A5B),
                fontSize = 20.sp
            )
        }
    }
}

@Composable
private fun HistoryServiceCard(
    date: String,
    time: String,
    type: String,
    typeColor: Color,
    technician: String,
    work: String,
    recommendation: String,
    amount: String,
    nextMaintenance: String,
    primaryBlue: Color,
    textDark: Color
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0xFFE1E6F0)),
        shadowElevation = 2.dp
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        .background(typeColor.copy(alpha = 0.13f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = if (type.contains("correctivo", ignoreCase = true)) "🛠" else "📅",
                        fontSize = 22.sp
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = type,
                        color = typeColor,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "$date · $time",
                        color = Color(0xFF5D6678),
                        fontSize = 13.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Técnico: $technician",
                        color = textDark,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

                Surface(
                    color = Color(0xFFEAF2FF),
                    shape = RoundedCornerShape(50.dp)
                ) {
                    Text(
                        text = amount,
                        color = primaryBlue,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Divider(color = Color(0xFFE1E6F0))

            Spacer(modifier = Modifier.height(12.dp))

            DetailBlock(
                title = "Trabajo realizado",
                value = work
            )

            Spacer(modifier = Modifier.height(10.dp))

            DetailBlock(
                title = "Recomendaciones",
                value = recommendation
            )

            Spacer(modifier = Modifier.height(10.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFF7F9FD),
                shape = RoundedCornerShape(12.dp)
            ) {
                Row(
                    modifier = Modifier.padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "📅",
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.width(10.dp))

                    Column {
                        Text(
                            text = "Próximo mantenimiento",
                            color = Color(0xFF5D6678),
                            fontSize = 12.sp
                        )

                        Text(
                            text = nextMaintenance,
                            color = Color(0xFF15803D),
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun DetailBlock(
    title: String,
    value: String
) {
    Column {
        Text(
            text = title,
            color = Color(0xFF17213D),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(4.dp))

        Text(
            text = value,
            color = Color(0xFF31415F),
            fontSize = 13.sp,
            lineHeight = 18.sp
        )
    }
}