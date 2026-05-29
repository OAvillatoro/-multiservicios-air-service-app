package com.multiserviciosoriente.airserviceapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.multiserviciosoriente.airserviceapp.presentation.screens.auth.LoginScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.auth.RegisterClientScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.equipment.EquipmentFormScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.equipment.EquipmentListScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.history.EquipmentHistoryScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.home.HomeAdminScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.home.HomeClientScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.home.HomeManagerScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.home.HomeTechnicianScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.profile.ClientProfileScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.requests.RequestInboxScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.requests.ScheduleTechnicianScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.requests.ServiceRequestFormScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.workorders.OrderDetailScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.workorders.TechnicianReportScreen
import com.multiserviciosoriente.airserviceapp.presentation.screens.workorders.WorkOrdersScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppRoutes.LOGIN
    ) {
        composable(AppRoutes.LOGIN) {
            LoginScreen(
                onRegisterClick = {
                    navController.navigate(AppRoutes.REGISTER_CLIENT)
                },
                onAdminLoginClick = {
                    navController.navigate(AppRoutes.HOME_ADMIN)
                },
                onClientLoginClick = {
                    navController.navigate(AppRoutes.HOME_CLIENT)
                },
                onManagerLoginClick = {
                    navController.navigate(AppRoutes.HOME_MANAGER)
                },
                onTechnicianLoginClick = {
                    navController.navigate(AppRoutes.HOME_TECHNICIAN)
                }
            )
        }

        composable(AppRoutes.REGISTER_CLIENT) {
            RegisterClientScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(AppRoutes.HOME_ADMIN) {
            HomeAdminScreen(
                onRequestInboxClick = {
                    navController.navigate(AppRoutes.REQUEST_INBOX)
                }
            )
        }

        composable(AppRoutes.HOME_CLIENT) {
            HomeClientScreen(
                onEquipmentListClick = {
                    navController.navigate(AppRoutes.EQUIPMENT_LIST)
                },
                onServiceRequestClick = {
                    navController.navigate(AppRoutes.SERVICE_REQUEST_FORM)
                },
                onHistoryClick = {
                    navController.navigate(AppRoutes.EQUIPMENT_HISTORY)
                },
                onProfileClick = {
                    navController.navigate(AppRoutes.CLIENT_PROFILE)
                }
            )
        }

        composable(AppRoutes.CLIENT_PROFILE) {
            ClientProfileScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(AppRoutes.HOME_MANAGER) {
            HomeManagerScreen(
                onRequestInboxClick = {
                    navController.navigate(AppRoutes.REQUEST_INBOX)
                }
            )
        }

        composable(AppRoutes.HOME_TECHNICIAN) {
            HomeTechnicianScreen(
                onWorkOrdersClick = {
                    navController.navigate(AppRoutes.WORK_ORDERS)
                },
                onOrderDetailClick = {
                    navController.navigate(AppRoutes.ORDER_DETAIL)
                },
                onReportClick = {
                    navController.navigate(AppRoutes.TECHNICIAN_REPORT)
                }
            )
        }

        composable(AppRoutes.EQUIPMENT_LIST) {
            EquipmentListScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onAddEquipmentClick = {
                    navController.navigate(AppRoutes.EQUIPMENT_FORM)
                },
                onRequestServiceClick = {
                    navController.navigate(AppRoutes.SERVICE_REQUEST_FORM)
                },
                onHistoryClick = {
                    navController.navigate(AppRoutes.EQUIPMENT_HISTORY)
                }
            )
        }

        composable(AppRoutes.EQUIPMENT_FORM) {
            EquipmentFormScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSaveClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(AppRoutes.SERVICE_REQUEST_FORM) {
            ServiceRequestFormScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onSubmitClick = {
                    navController.popBackStack()
                },
                isAdmin = false
            )
        }

        composable(AppRoutes.REQUEST_INBOX) {
            RequestInboxScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onScheduleClick = {
                    navController.navigate(AppRoutes.SCHEDULE_TECHNICIAN)
                },
                onDetailClick = {
                    navController.navigate(AppRoutes.ORDER_DETAIL)
                }
            )
        }

        composable(AppRoutes.SCHEDULE_TECHNICIAN) {
            ScheduleTechnicianScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(AppRoutes.WORK_ORDERS) {
            WorkOrdersScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onDetailClick = {
                    navController.navigate(AppRoutes.ORDER_DETAIL)
                },
                onReportClick = {
                    navController.navigate(AppRoutes.TECHNICIAN_REPORT)
                }
            )
        }

        composable(AppRoutes.ORDER_DETAIL) {
            OrderDetailScreen(
                onBackClick = {
                    navController.popBackStack()
                },
                onReportClick = {
                    navController.navigate(AppRoutes.TECHNICIAN_REPORT)
                }
            )
        }

        composable(AppRoutes.TECHNICIAN_REPORT) {
            TechnicianReportScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(AppRoutes.EQUIPMENT_HISTORY) {
            EquipmentHistoryScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}